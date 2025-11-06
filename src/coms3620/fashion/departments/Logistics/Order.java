package coms3620.fashion.departments.Logistics;

import java.util.List;


public class Order implements Trackable {
    enum Status {PENDING, EXPEDITED}
    private final String id;
    private final List<OrderLine> orderLines;
    private Status status;

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

    public void updateStatus() {

    }

    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }
}