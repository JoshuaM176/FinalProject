package coms3620.fashion.menus.logistics.manage_shipments;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Option;

public class CancelShipment implements Option {
    private LogisticsManager logisticsManager;

    public CancelShipment(LogisticsManager logisticsManager) {
        this.logisticsManager = logisticsManager;
    }

    @Override
    public String getName() {
        return "Cancel shipment";
    }

    @Override
    public void run() {
        logisticsManager.cancelShipment();
    }
    
}
