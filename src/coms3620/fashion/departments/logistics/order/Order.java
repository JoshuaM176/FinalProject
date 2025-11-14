package coms3620.fashion.departments.logistics.order;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import coms3620.fashion.departments.logistics.Status;
import coms3620.fashion.departments.logistics.Trackable;


public class Order implements Trackable {
    private final String id;
    private final List<OrderLine> orderLines;
    private Status status;
    private Map<String, Integer> productQuantities = new HashMap<>();


    public Order(String id, List<OrderLine> orderLines) {
        this.id = id;
        this.orderLines = orderLines;
        this.status = Status.PENDING;
    }

    public String getID() {
        return this.id;
    }

    public String getStatus() {
        return status.toString();
    }

    public void updateStatus(Status status) {

    }

    public void finalizeOrder() {
        productQuantities.clear();
        for (OrderLine ol : orderLines) {
            productQuantities.merge(ol.getSKU(), ol.getQuantity(), Integer::sum);
        }
    }

    public String generateSummary() {
        HashSet<String> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        sb.append("================ Order Summary ===================\n")
        .append("Order ID: ").append(id).append("\n")
        .append("Status: ").append(status).append("\n")
        .append("--------------------------------------------------\n");

        if (productQuantities.isEmpty()) {
            sb.append("  (No products added or order not finalized)\n")
            .append("==================================================\n");
            return sb.toString();
        }

        // Column header
        sb.append(String.format("%-25s %-20s %-8s\n", "Product", "SKU", "Qty"));

        int totalQuantity = 0;

        for (OrderLine ol : orderLines) {
            String sku = ol.getSKU();

            if (productQuantities.containsKey(sku) && !seen.contains(sku)) {
                sb.append(String.format("%-25s %-20s %-8d\n",
                    ol.getName(),
                    ol.getSKU(),
                    productQuantities.get(sku)));

                totalQuantity += productQuantities.get(sku);
                seen.add(sku);
            }
        }

        sb.append("--------------------------------------------------\n")
        .append("Total quantity: ").append(totalQuantity).append("\n")
        .append("==================================================\n");

        return sb.toString();
    }

    @Override
    public String toString() {
        HashSet<String> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(id).append("\n")
          .append("Products in this order:\n");

        if (productQuantities.isEmpty()) {
            sb.append("  (No products added or order not finalized)\n");
        } else {
            int totalQuantity = 0;
            for (OrderLine ol : orderLines) {
                String sku = ol.getSKU();
                if (productQuantities.containsKey(sku) && !seen.contains(sku)) {
                    sb.append("  ")
                    .append(ol)
                    .append(" - quantity: ")
                    .append(productQuantities.get(sku))
                    .append("\n");
                    totalQuantity += productQuantities.get(sku);
                    seen.add(sku);
                }
            }
            sb.append("Total quantity: ").append(totalQuantity).append("\n");
        }

        return sb.toString();
    }

    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }
}