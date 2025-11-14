package coms3620.fashion.departments.logistics.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import coms3620.fashion.util.RandStringGenerator;
import coms3620.fashion.util.Stdin;

public class OrderManager {
    private List<Order> orders;
    private Map<String, String> availableProducts;
    private final RandStringGenerator randString;

    public OrderManager() {
        orders = new ArrayList<>();
        randString = new RandStringGenerator();
        availableProducts = new HashMap<>();
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public Order createOrder(List<OrderLine> ols) {
        Order order = new Order(randString.generateRandomString(8), ols);
        order.finalizeOrder();
        orders.add(order);

        return order;
    }

    public void viewOrders() {
        System.out.println();
        if (orders.isEmpty())
            System.out.println("There are currently no orders.");
        else {
            int index = 1;
            for (Order order : orders) {
                System.out.println("Order no. " + index);
                System.out.println(order.generateSummary());
                index++;
            }
        }
    }

    public void deleteOrder() {
        System.out.println();
        if (orders.isEmpty()) {
            System.out.println("There are currently no orders to delete.");
            return;
        }
        System.out.print("Enter order number --> ");
        int index = Stdin.nextInt();
        if (index > orders.size()) 
            System.out.println("Order was not deleted - no such order.");
        else {
            orders.remove(index - 1);
            System.out.println("Order was successfully deleted.");
        }
    }

    public String getSKU(String name) {
        return availableProducts.get(name);
    }

    /**
     * TEMPORARY
     */
    public void printAvailableProducts() {
        availableProducts.clear();
        availableProducts.put("shirt", "TSH-M-BLK-NK-001");
        availableProducts.put("hat", "HAT-M-GRY-NK-001" );
        availableProducts.put("pants", "PNT-BLU-LEV-001");
        System.out.println("Avaliable products:");
        for (String key : availableProducts.keySet()) {
            System.out.println(key);
        }
        System.out.println();
    }

    public boolean isValidInput(String name) {
        if (!availableProducts.containsKey(name)) 
            return false;
        else
            return true;
    }

    public boolean isValidInput(int quantity) {
        if (quantity <= 0) 
            return false;
        else
            return true;
    }

}
