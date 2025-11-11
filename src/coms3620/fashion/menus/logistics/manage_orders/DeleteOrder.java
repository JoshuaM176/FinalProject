package coms3620.fashion.menus.logistics.manage_orders;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Option;

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
        logisticsManager.deleteOrder();
    }
    
}
