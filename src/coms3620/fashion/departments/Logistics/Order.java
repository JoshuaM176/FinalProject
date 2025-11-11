package coms3620.fashion.departments.logistics;

import java.util.HashMap;
import java.util.List;


public class Order implements Trackable {
    enum Status {PENDING, EXPEDITED}
    private final String id;
    private final List<OrderLine> orderLines;
    private Status status;
    private HashMap<String, Integer> productQuantities = new HashMap<>();


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

    public void finalizeOrder() {
        productQuantities.clear();
        for (OrderLine ol : orderLines) {
            productQuantities.merge(ol.getSKU(), ol.getQuantity(), Integer::sum);
        }
    }


    @Override
   public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(id).append("\n")
          .append("Products in this order:\n");

        if (productQuantities.isEmpty()) {
            sb.append("  (No products added or order not finalized)\n");
        } else {
            int totalQuantity = 0;
            for (OrderLine ol : orderLines) {
                String sku = ol.getSKU();
                if (productQuantities.containsKey(sku)) {
                    sb.append("  ")
                    .append(ol)
                    .append(" - quantity: ")
                    .append(productQuantities.get(sku))
                    .append("\n");
                    totalQuantity += productQuantities.get(sku);
                    // Prevent duplicate printing for same SKU
                    // productQuantities.remove(sku);
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