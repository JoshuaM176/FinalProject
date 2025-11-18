package coms3620.fashion.menus.logistics.manage_orders;

import java.util.ArrayList;
import java.util.List;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.departments.logistics.Product;
import coms3620.fashion.departments.logistics.order.Order;
import coms3620.fashion.departments.logistics.order.OrderLine;
import coms3620.fashion.menus.Option;
import coms3620.fashion.util.Stdin;

public class CreateOrder implements Option {
    private LogisticsManager logisticsManager;

    public CreateOrder(LogisticsManager logisticsManager) {
        this.logisticsManager = logisticsManager;
    }

    @Override
    public String getName() {
        return "Create order";
    }

    @Override
    public void run() {
        System.out.println();
        new ViewAvailableProducts(logisticsManager).run();
        List<OrderLine> orderLines = new ArrayList<>();
        boolean keepAdding = true;

        do {
            System.out.print("Enter name of the product --> ");
            String name = Stdin.nextLine();
            System.out.println();

            while (!logisticsManager.containsProduct(name)) {
                System.out.print("Invalid product name, please try again --> ");
                name = Stdin.nextLine();
                System.out.println();
            }
 
            System.out.print("Enter product quantity --> ");
            int quantity = Stdin.nextInt();
            System.out.println();

            while (!logisticsManager.reduceProductQuantity(name, quantity)) {
                System.out.print("Invalid quantity, please try again --> ");
                quantity = Stdin.nextInt();
                System.out.println();
            }

            Product p = logisticsManager.getProductByName(name);
            orderLines.add(new OrderLine(p, quantity));

            System.out.println();
            System.out.println("Add another product?");
            System.out.print("[Y]es / [N]o --> ");
            char choice = Stdin.nextLine().charAt(0);
            keepAdding = choice == 'y';
            System.out.println();

        } while (keepAdding);

        Order order = logisticsManager.createOrder(orderLines);
        System.out.println("New order was successfully made, id: " + order.getID());
        System.out.println();
    }



    // @Override
    // public void run() {
    //     System.out.println();
    //     logisticsManager.printAvailableProducts();
    //     List<OrderLine> orderLines = new ArrayList<>();
    //     int keepAdding = 0;

    //     do {
    //         System.out.print("Enter name of the product --> ");
    //         String name = Stdin.nextLine();
    //         System.out.println();

    //         while (!logisticsManager.isValidInput(name)) {
    //             System.out.print("Invalid product name, please try again --> ");
    //             name = Stdin.nextLine();
    //             System.out.println();
    //         }

    //         System.out.print("Enter product quantity --> ");
    //         int quantity = Stdin.nextInt();
    //         System.out.println();

    //         while (!logisticsManager.isValidInput(quantity)){
    //             System.out.print("Invalid quantity, please try again --> ");
    //             quantity = Stdin.nextInt();
    //             System.out.println();
    //         }

    //         String sku = logisticsManager.getSKU(name);
    //         orderLines.add(new OrderLine(name, sku, quantity));

    //         System.out.print("Add another product? (2 = no) --> ");
    //         keepAdding = Stdin.nextInt();
    //         System.out.println();

    //     } while(keepAdding != 2);

    //     Order order = logisticsManager.createOrder(orderLines);
    //     System.out.println("New order was successfully made, id: " + order.getID());
    //     System.out.println();
    // }
}
