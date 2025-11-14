package coms3620.fashion.menus.logistics.manage_orders;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.departments.logistics.order.Order;
import coms3620.fashion.menus.Option;

public class ViewOrders implements Option {
    private LogisticsManager logisticsManager;

    public ViewOrders(LogisticsManager logisticsManager) {
        this.logisticsManager = logisticsManager;
    }

    @Override
    public String getName() {
        return "View orders";
    }

    public void run() {
        System.out.println();
        if (logisticsManager.getOrders().isEmpty())
            System.out.println("There are currently no orders.");
        else {
            int index = 1;
            for (Order order : logisticsManager.getOrders()) {
                System.out.println("Order no. " + index);
                System.out.println(order.generateSummary());
                index++;
            }
        }
    }
    
}
