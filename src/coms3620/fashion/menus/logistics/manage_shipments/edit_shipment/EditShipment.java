package coms3620.fashion.menus.logistics.manage_shipments.edit_shipment;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.Option;

public class EditShipment extends Menu implements Option  {
    // private LogisticsManager logisticsManager;

    public EditShipment(LogisticsManager logisticsManager) {
        // this.logisticsManager = logisticsManager;

        AddProducts addProducts = new AddProducts();
        RemoveProducts removeProducts = new RemoveProducts();
        UpdateShipmentStatus updateShipmentStatus = new UpdateShipmentStatus();

        addOption(updateShipmentStatus);
        addOption(removeProducts);
        addOption(addProducts);
    }

    @Override
    public String getName() {
        return "Edit shipment";
    }

    @Override
    public void run() {
        enter_menu();
    }
    
}
