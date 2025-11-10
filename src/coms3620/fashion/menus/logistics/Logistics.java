package coms3620.fashion.menus.logistics;

import coms3620.fashion.menus.*;
import coms3620.fashion.menus.logistics.manage_orders.ManageOrders;

public class Logistics extends Menu implements Option {

    public Logistics() {
        ManageOrders manageOrders = new ManageOrders();
        addOption(manageOrders);
    }

    @Override
    public String getName() {
        return "Logistics";
    }

    @Override
    public void run() {
        enter_menu();
    }
    
}
