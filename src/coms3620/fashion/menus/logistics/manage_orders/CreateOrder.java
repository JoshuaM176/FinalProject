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
        ViewAvailableProducts viewAvailableProducts = new ViewAvailableProducts(logisticsManager);
        viewAvailableProducts.run();
        List<OrderLine> orderLines = new ArrayList<>();
        boolean keepAdding = true;

        do {
            System.out.print("Enter keyword(s) -- > ");
            String keyWord = Stdin.nextLine();
            System.out.println();

            List<Product> matches = logisticsManager.findProductsByName(keyWord);

            while (matches.isEmpty()) {
                System.out.print("No products match that keyword, please try again --> ");
                keyWord = Stdin.nextLine();
                System.out.println();
                matches = logisticsManager.findProductsByName(keyWord);
            }

            if (matches.size() == 1)
                System.out.println("1 product found:");
            else
                System.out.println(matches.size() + " products found:");
            
            System.out.printf("%-33s %-20s %-10s %-10s %-10s\n",
                "Name", "SKU", "Size", "Price", "Stock");
            System.out.println("-----------------------------------------------------------------------------------");
            int index = 1;
            for (Product p : matches) {
                viewAvailableProducts.productFormatter(p, index++);
            }

            System.out.println();
            System.out.print("Choose product number --> ");
            int choice = Stdin.nextInt();
            System.out.println();

            while (choice <= 0 || choice > matches.size()) {
                System.out.print("Invalid. Please try again --> ");
                choice = Stdin.nextInt();
                System.out.println();
            }

            Product p = matches.get(choice - 1);

            System.out.print("Enter product quantity --> ");
            int quantity = Stdin.nextInt();
            System.out.println();

            while (!logisticsManager.reduceProductQuantity(p.getSKU(), quantity)) {
                System.out.print("Insufficient stock, only " + p.getQuantity() + " remaining. please try again --> ");
                quantity = Stdin.nextInt();
                System.out.println();
            }
            orderLines.add(new OrderLine(p, quantity));

            System.out.println("Add another product?");
            System.out.print("[Y]es / [N]o --> ");
            char keepAddingChoice = Stdin.nextLine().charAt(0);
            keepAdding = keepAddingChoice == 'y' || keepAddingChoice == 'Y';
            System.out.println();

        } while(keepAdding);

        Order order = logisticsManager.createOrder(orderLines);
        System.out.println("New order was successfully made, id: " + order.getID());
    }

    // @Override
    // public void run() {
    //     System.out.println();
    //     new ViewAvailableProducts(logisticsManager).run();
    //     List<OrderLine> orderLines = new ArrayList<>();
    //     boolean keepAdding = true;

    //     do {
    //         System.out.print("Enter name of the product --> ");
    //         String name = Stdin.nextLine();
    //         System.out.println();

    //         while (!logisticsManager.containsProduct(name)) {
    //             System.out.print("Invalid product name, please try again --> ");
    //             name = Stdin.nextLine();
    //             System.out.println();
    //         }
 
    //         System.out.print("Enter product quantity --> ");
    //         int quantity = Stdin.nextInt();
    //         System.out.println();

    //         while (!logisticsManager.reduceProductQuantity(name, quantity)) {
    //             System.out.print("Invalid quantity, please try again --> ");
    //             quantity = Stdin.nextInt();
    //             System.out.println();
    //         }

    //         Product p = logisticsManager.getProductByName(name);
    //         orderLines.add(new OrderLine(p, quantity));

    //         System.out.println();
    //         System.out.println("Add another product?");
    //         System.out.print("[Y]es / [N]o --> ");
    //         char choice = Stdin.nextLine().charAt(0);
    //         keepAdding = choice == 'y';
    //         System.out.println();

    //     } while (keepAdding);

    //     Order order = logisticsManager.createOrder(orderLines);
    //     System.out.println("New order was successfully made, id: " + order.getID());
    //     System.out.println();
    // }
}
