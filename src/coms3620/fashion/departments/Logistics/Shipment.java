package coms3620.fashion.departments.logistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Shipment implements Trackable {
    enum Status {PENDING, SHIPPED, EARLY, LATE, ARRIVED}
    private String id;
    private List<Order> orders = new ArrayList<>();
    private Status status;
    private Map<String, Integer> shipment = new HashMap();

    public Shipment(List<Order> orders, String id) {
        this.orders = orders;
        this.id = id;
        status = Status.PENDING;
    }

    public String getID() {
        return this.id;
    }

    public void finalizeShipment() {
        shipment.clear();
        for (Order order : orders) {
            for (OrderLine ol : order.getOrderLines()) {
                shipment.merge(ol.getSKU(), ol.getQuantity(), Integer::sum);
            }
        }
        this.status = Status.SHIPPED;
    }

    public String getStatus() {
        return status.toString();
    }

    // @Override
    // public String toString() {
    //     StringBuilder sb = new StringBuilder();
    //     sb.append("Shipment ID: ").append(id).append("\n");
    //     sb.append("Status: ").append(status).append("\n");
    //     sb.append("Orders in shipment: ").append(orders.size()).append("\n\n");

    //         if (shipment.isEmpty()) {
    //             sb.append("  (No products finalized yet)\n");
    //         } else {
    //             sb.append("Products in shipment:\n");
    //             int totalQuantity = 0;

    //             for (var entry : shipment.entrySet()) {
    //                 OrderLine product = entry.getKey();
    //                 int quantity = entry.getValue();

    //                 sb.append("  ").append(product.toString())
    //                 .append(" - Quantity: ")
    //                 .append(quantity).append("\n");

    //                 totalQuantity += quantity;
    //             }

    //             sb.append("Shipment quantity: ")
    //             .append(totalQuantity)
    //             .append("\n");
    //         }
        
    //     return sb.toString();
    // }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        HashSet<String> seen = new HashSet<>();

        sb.append("Shipment ID: ").append(id).append("\n");
        sb.append("Status: ").append(status).append("\n\n");

        if (shipment.isEmpty())
            sb.append(". (No products finilized yet.)");
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

    public void updateStatus() {
        
    }
    
}
