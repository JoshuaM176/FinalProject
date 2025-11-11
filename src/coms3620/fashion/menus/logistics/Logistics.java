package coms3620.fashion.menus.logistics;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.*;
import coms3620.fashion.menus.logistics.manage_orders.ManageOrders;
import coms3620.fashion.menus.logistics.manage_shipments.ManageShipments;

public class Logistics extends Menu implements Option {

    public Logistics() {
        LogisticsManager lm = new LogisticsManager();

        ManageOrders manageOrders = new ManageOrders(lm);
        ManageShipments manageShipments = new ManageShipments(lm);
        
        addOption(manageOrders);
        addOption(manageShipments);
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
