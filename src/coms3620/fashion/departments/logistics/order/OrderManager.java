package coms3620.fashion.departments.logistics.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import coms3620.fashion.misc.RandStringGenerator;
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

    /**
     * FOR TESTING
     * @param orderLines
     */
    public void createOrder(List<OrderLine> ols, String id) {
        Order order = new Order(id, ols);
        order.finalizeOrder();
        this.orders.add(order);
    }

    public void createOrder() {
        System.out.println();
        printAvailableProducts();
        List<OrderLine> orderLines = new ArrayList<>();
        int keepAdding = 0;
        
        do {
            System.out.print("Enter name of the product --> ");
            String name = Stdin.nextLine();
            System.out.println();

            while (!isValidInput(name)) {
                System.out.print("Invalid product name, please try again --> ");
                name = Stdin.nextLine();
                System.out.println();
            }

            System.out.print("Enter product quantity --> ");
            int quantity = Stdin.nextInt();
            System.out.println();

            while (!isValidInput(quantity)){
                System.out.print("Invalid quantity, please try again --> ");
                quantity = Stdin.nextInt();
                System.out.println();
            }

            String sku = availableProducts.get(name);
            orderLines.add(new OrderLine(name, sku, quantity));

            System.out.print("Add another product? (2 = no) --> ");
            keepAdding = Stdin.nextInt();
            System.out.println();

        } 
        while(keepAdding != 2);

        Order order = new Order(randString.generateRandomString(8), orderLines);
        order.finalizeOrder();
        orders.add(order);

        System.out.println("New order was successfully made, id: " + order.getID());
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
