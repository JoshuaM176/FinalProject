package coms3620.fashion.menus.logistics.manage_shipments;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Option;

public class CreateShipment implements Option {
    private LogisticsManager logisticsManager;

    public CreateShipment(LogisticsManager logisticsManager) {
        this.logisticsManager = logisticsManager;
    }

    @Override
    public String getName() {
        return "Create Shipment";
    }

    @Override
    public void run() {
        logisticsManager.createShipment();
    }


}
