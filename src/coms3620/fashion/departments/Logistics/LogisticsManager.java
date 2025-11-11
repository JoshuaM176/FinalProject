package coms3620.fashion.departments.logistics;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import coms3620.fashion.misc.RandStringGenerator;
import coms3620.fashion.util.Stdin;

public class LogisticsManager {
    List<Order> orders = new ArrayList<>();
    List<String> availableProducts = new ArrayList<>();

    public void printAvailableProducts() {
        availableProducts.clear();
        availableProducts.add("shirt");
        availableProducts.add("hat");
        availableProducts.add("pants");
        System.out.println("Avaliable products:");
        for (String s : availableProducts) {
            System.out.println(s);
        }
        System.out.println();
    }

    public void createOrder() {
        System.out.println();
        printAvailableProducts();
        RandStringGenerator rand = new RandStringGenerator();
        List<OrderLine> orderLines = new ArrayList<>();
        int keepAdding = 0;

        
        do {
            try {
                System.out.print("Enter name of the product --> ");
                String name = Stdin.nextLine();
                System.out.println();

                System.out.print("Enter product SKU --> ");
                String sku = Stdin.nextLine();
                System.out.println();

                System.out.print("Enter product quantity --> ");
                int quantity = Stdin.nextInt();
                System.out.println();

                if (!isValidInput(name.toLowerCase(), sku.toLowerCase(), quantity))
                    throw new InputMismatchException();

                orderLines.add(new OrderLine(name, sku, quantity));

                System.out.print("Add another product? (2 = no) --> ");
                keepAdding = Stdin.nextInt();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                System.out.println();
            }
        } 
        while(keepAdding != 2);

        Order order = new Order(rand.generateRandomString(8), orderLines);
        order.finalizeOrder();
        orders.add(order);

        System.out.println("New order was successfully made, id: " + order.getID());
    }

    public boolean isValidInput(String name, String sku, int quantity) {
        if (!availableProducts.contains(name) || quantity <= 0) 
            return false;
        else
            return true;
    }

    public void viewOrders() {
        System.out.println();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

}
