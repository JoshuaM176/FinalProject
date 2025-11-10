package coms3620.fashion.departments.logistics;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import coms3620.fashion.misc.RandStringGenerator;

public class LogisticsManager {
    List<Order> orders = new ArrayList<>();

    public void createOrder() {
        System.out.println();
        Scanner scan = new Scanner(System.in);  
        RandStringGenerator rand = new RandStringGenerator();
        List<OrderLine> orderLines = new ArrayList<>();
        int keepAdding = 0;

        do {
            try {
                System.out.print("Enter name of the product --> ");
                String name = scan.next();
                System.out.println();

                System.out.print("Enter product SKU --> ");
                String sku = scan.next();
                System.out.println();

                System.out.print("Enter product quantity --> ");
                int quantity = scan.nextInt();
                if (quantity <= 0)
                    throw new InputMismatchException();
                System.out.println();

                orderLines.add(new OrderLine(name, sku, quantity));

                while (true) {
                    try {
                        System.out.print("Add another product?\n(1 = yes, 2 = no) --> ");
                        keepAdding = scan.nextInt();
                        if (keepAdding == 1 || keepAdding == 2)
                            break;
                        else
                            throw new InputMismatchException();
                    }
                    catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("Invald input, try again.");
                        scan.nextLine();
                        System.out.println();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
            }

        } while(keepAdding != 2);

        orders.add(new Order(rand.generateRandomString(8), orderLines));
        System.out.println();
    }

    public void viewOrders() {
        System.out.println();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

}
