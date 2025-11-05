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
    private Map<Product, Integer> products = new HashMap();

    public Shipment(String id) {
        this.id = id;
        status = Status.PENDING;
    }

    public String getID() {
        return this.id;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void finalizeShipment() {
        products.clear();
        for (Order order : orders) {
            for (Product product : order.getProducts()) {
                int quantity = product.getQuantity();
                products.merge(product, quantity, Integer::sum);
            }
        }
        this.status = Status.SHIPPED;
    }

    public String getStatus() {
        return status.toString();
    }

    public void updateStatus() {
        
    }
    
}
