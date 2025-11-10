package coms3620.fashion.menus.logistics.manage_orders;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Option;

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
        logisticsManager.createOrder();
    }
    
}
