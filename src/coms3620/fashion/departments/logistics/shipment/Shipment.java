package coms3620.fashion.departments.logistics.shipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import coms3620.fashion.departments.logistics.Trackable;
import coms3620.fashion.departments.logistics.order.Order;
import coms3620.fashion.departments.logistics.order.OrderLine;

public class Shipment implements Trackable {
    private String id;
    private List<Order> orders = new ArrayList<>();
    private Status status;
    private static Map<String, Integer> shipment = new HashMap();

    public Shipment(List<Order> orders, String id) {
        this.orders = orders;
        this.id = id;
        status = Status.PENDING;
    }

    public String getID() {
        return this.id;
    }

    private void compileQuantities() {
        shipment.clear();
        for (Order order : orders) {
            for (OrderLine ol : order.getOrderLines()) {
                shipment.merge(ol.getSKU(), ol.getQuantity(), Integer::sum);
            }
        }
    }

    public String getStatus() {
        return status.toString();
    }

    public String generateInvoice() {
        compileQuantities();
        HashSet<String> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        sb.append("=========== Fashion Logistics Invoice =============\n")
            .append("Shipment ID: ").append(id).append("\n")
            .append("Orders: ");
        for (Order order : orders)
            sb.append(order.getID())
                .append(" ");
        sb.append("\n---------------------------------------------------\n")
            .append(String.format("%-25s %-20s %-8s\n", "Product", "SKU", "Qty"));
        for (Order order : orders) {
            for (OrderLine ol : order.getOrderLines()) {
                String sku = ol.getSKU();
                if (shipment.containsKey(sku) && !seen.contains(sku)) {
                        sb.append(String.format("%-25s %-20s %-8d\n",
                        ol.getName(),
                        ol.getSKU(),
                        shipment.get(sku)));
                        seen.add(sku);
                    }
            }
        }
        sb.append("---------------------------------------------------\n")
            .append("Total items: ")
            .append(shipment.values().stream().mapToInt(Integer::intValue).sum())
            .append("\n")
            .append("Status: ").append(status).append("\n")
            .append("===================================================\n");

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        HashSet<String> seen = new HashSet<>();

        sb.append("Shipment ID: ").append(id).append("\n");
        sb.append("Status: ").append(status).append("\n\n");

        if (shipment.isEmpty())
            sb.append(". (No products finalized yet.)");
        else {
            sb.append("Orders in shipment (by order no.):\n");
            int totalQuantity = 0;
            sb.append("  ");
            for (Order order : orders) {
                if (order.equals(orders.get(orders.size()-1)))
                    sb.append(order.getID());
                else
                    sb.append(order.getID()).append(", ");
            }
            sb.append("\n\n")
            .append("Products in this shipment:\n");
      
            for (Order order : orders) {
                for (OrderLine ol : order.getOrderLines()) {
                    String sku = ol.getSKU();
                    if (shipment.containsKey(sku) && !seen.contains(sku)) {
                        sb.append("  ")
                        .append(ol)
                        .append(" - quantity: ")
                        .append(shipment.get(sku))
                        .append("\n");
                        totalQuantity += shipment.get(sku);
                        seen.add(sku);
                    }
                }
            }
            sb.append("Shipment quantity: ")
                .append(totalQuantity)
                .append("\n");
        }

        return sb.toString();
    }

    @Override
    public void updateStatus(Status status) {
        this.status = status;
    }

}
