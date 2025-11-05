package coms3620.fashion.departments.Logistics;

import java.util.List;


public class Order implements Trackable {
    enum Status {PENDING, EXPEDITED}
    private final String id;
    private final List<Product> products;
    private Status status;

    public Order(String id, List<Product> products) {
        this.id = id;
        this.products = products;
        this.status = Status.PENDING;
    }

    public String getID() {
        return this.id;
    }

    public String getStatus() {
        return status.toString();
    }

    public void updateStatus() {

    }

    public List<Product> getProducts() {
        return this.products;
    }
}