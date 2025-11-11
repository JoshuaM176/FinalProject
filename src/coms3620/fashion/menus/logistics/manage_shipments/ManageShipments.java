package coms3620.fashion.menus.logistics.manage_shipments;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.Option;

public class ManageShipments extends Menu implements Option {

    public ManageShipments(LogisticsManager logisticsManager) {
        CreateShipment createShipment = new CreateShipment(logisticsManager);
        ViewShipments viewShipments = new ViewShipments(logisticsManager);

        addOption(createShipment);
        addOption(viewShipments);
    }
    
    @Override
    public String getName() {
        return "Manage Shipments";
    }

    @Override
    public void run() {
        enter_menu();
    }

}
