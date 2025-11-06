package coms3620.fashion.departments.Logistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shipment implements Trackable {
    enum Status {PENDING, SHIPPED, EARLY, LATE, ARRIVED}
    private String id;
    private List<Order> orders = new ArrayList<>();
    private Status status;
    private Map<OrderLine, Integer> shipment = new HashMap();

    public Shipment(String id) {
        this.id = id;
        status = Status.PENDING;
    }

    public String getID() {
        return this.id;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void finalizeShipment() {
        shipment.clear();
        for (Order order : orders) {
            for (OrderLine product : order.getOrderLines()) {
                int quantity = product.getQuantity();
                shipment.merge(product, quantity, Integer::sum);
            }
        }
        this.status = Status.SHIPPED;
    }

    public String getStatus() {
        return status.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shipment ID: ").append(id).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("Orders in shipment: ").append(orders.size()).append("\n\n");

            if (shipment.isEmpty()) {
                sb.append("  (No products finalized yet)\n");
            } else {
                sb.append("Products in shipment:\n");
                int totalQuantity = 0;

                for (var entry : shipment.entrySet()) {
                    OrderLine product = entry.getKey();
                    int quantity = entry.getValue();

                    sb.append("  ").append(product.toString())
                    .append(" - Quantity: ")
                    .append(quantity).append("\n");

                    totalQuantity += quantity;
                }

                sb.append("\nShipment quantity: ")
                .append(totalQuantity)
                .append("\n");
            }
        
        return sb.toString();
    }

    public void updateStatus() {
        
    }
    
}
