package coms3620.fashion.menus.productdevelopment;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import coms3620.fashion.departments.logistics.*;
import coms3620.fashion.departments.logistics.order.Order;
import coms3620.fashion.departments.logistics.order.OrderLine;
import coms3620.fashion.departments.product_development.Prototype;
import coms3620.fashion.departments.product_development.PrototypeRepository;
import coms3620.fashion.menus.Option;
import coms3620.fashion.util.InputValidation;
import coms3620.fashion.util.Stdin;

public class IssueSafetyRecall implements Option {

    private final PrototypeRepository repo;
    private final LogisticsManager logistics;

    public IssueSafetyRecall(PrototypeRepository repo, LogisticsManager logistics) {
        this.repo = repo;
        this.logistics = logistics;
    }

    @Override
    public String getName() {
        return "Issue Safety Recall";
    }

    @Override
    public void run() {
        // 1.  eligible = approved only
        List<Prototype> eligible = repo.findAll()
                .stream()
                .filter(Prototype::isApproved)
                .collect(Collectors.toList());

        if (eligible.isEmpty()) {
            System.out.println("No approved prototypes eligible for recall.");
            return;
        }

        // 2.  pick faulty prototype
        System.out.println("Select prototype to recall:");
        for (int i = 0; i < eligible.size(); i++) {
            Prototype p = eligible.get(i);
            System.out.printf("%d. %s (material: %s)%n", i + 1, p.getConceptName(), p.getMaterials());
        }
        int idx = InputValidation.IntegerRangeInput(1, eligible.size()) - 1;
        Prototype faulty = eligible.get(idx);

        // 3.  reason & severity
        System.out.print("Recall reason (free text): ");
        String reason = Stdin.nextLine().trim();
        System.out.println("Severity: 1=Low  2=Medium  3=High");
        int severity = InputValidation.IntegerRangeInput(1, 3);

        // 4.  confirm
        System.out.printf("Issue recall for '%s'? 1=Yes  0=Cancel%n", faulty.getConceptName());
        if (InputValidation.IntegerRangeInput(0, 1) == 0) {
            return;
        }

        // 5.  mark prototype RECALLED (new status)
        faulty.approve();          // cannot be ordered again
        faulty.setLastActor("recall");
        faulty.setLastNote("Safety recall – " + reason + "  Sev=" + severity);

        // 6.  find all **existing** orders that contain this prototype
        List<Order> allOrders = logistics.getOrders(); // assume LogisticsManager exposes this
        List<Order> affected = new ArrayList<>();
        for (Order o : allOrders) {
            boolean contains = o.getOrderLines().stream()
                    .anyMatch(ol -> ol.getSKU().startsWith(faulty.getId().toString()));
            if (contains) {
                affected.add(o);
            }
        }

        // 7.  create one **recall shipment** that aggregates all affected orders
        String recallId = "RECALL-" + faulty.getId();
        List<OrderLine> recallLines = new ArrayList<>();
        for (Order o : affected) {
            for (OrderLine ol : o.getOrderLines()) {
                if (ol.getSKU().startsWith(faulty.getId().toString())) {
                    // clone line but prefix SKU with RECALL-
                    OrderLine recallLine = new OrderLine(
                            ol.getProductName() + " (RECALL)",
                            "RECALL-" + ol.getSKU(),
                            ol.getQuantity());
                    recallLines.add(recallLine);
                }
            }
        }

        if (!recallLines.isEmpty()) {
            Order recallOrder = new Order(recallId, recallLines);
            recallOrder.finalizeOrder();
            logistics.createShipment(List.of(recallOrder)); // reuse existing shipment creator
        }

        // 8.  immutable recall log
        logRecall(faulty.getId(), reason, severity, affected.size());

        // 9.  save prototype changes
        repo.save();

        System.out.printf("Recall issued: %d orders affected, shipment %s created.%n",
                affected.size(), recallId);
    }

    /* ---------- immutable recall log ---------- */
    private void logRecall(String protoId, String reason, int severity, int orderCount) {
        Path log = Paths.get("data/product_development/recalls.csv");
        try {
            Files.createDirectories(log.getParent());
            String line = String.join(",",
                    LocalDateTime.now().toString(),
                    protoId,
                    String.valueOf(severity),
                    "\"" + reason.replace("\"", "\"\"") + "\"",
                    String.valueOf(orderCount));
            Files.writeString(log, line + System.lineSeparator(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Recall log failed: " + e.getMessage());
        }
    }
}
