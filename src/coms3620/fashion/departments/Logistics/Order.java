package coms3620.fashion.departments.logistics;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Order id: " + id)
        .append("\n")
        .append("Products in this order:")
        .append("\n");

        for (OrderLine ol : orderLines) {
            sb.append(ol)
            .append("\n");
        }

        return sb.toString();
    }

    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }
}