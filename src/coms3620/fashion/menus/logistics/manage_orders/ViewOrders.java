package coms3620.fashion.menus.logistics.manage_orders;

import coms3620.fashion.departments.logistics.LogisticsManager;
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
        logisticsManager.viewOrders();
    }
    
}
