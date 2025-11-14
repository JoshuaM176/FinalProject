package coms3620.fashion.menus.logistics.manage_orders;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Option;
import coms3620.fashion.util.Stdin;

public class DeleteOrder implements Option {
    private LogisticsManager logisticsManager;

    public DeleteOrder(LogisticsManager logisticsManager) {
        this.logisticsManager = logisticsManager;
    }

    @Override
    public String getName() {
        return "Delete order";
    }

    @Override
    public void run() {
        System.out.println();
        if (logisticsManager.getOrders().isEmpty()) {
            System.out.println("There are currently no orders to delete.");
            return;
        }
        System.out.print("Enter order number --> ");
        int index = Stdin.nextInt();
        if (index > logisticsManager.getOrders().size())
            System.out.println("Order was not deleted - no such order.");
        else {
            logisticsManager.getOrders().remove(index - 1);
            System.out.println("Order no. " + index + " was successfully deleted.");
        }

    }
    
}
