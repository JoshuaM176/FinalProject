package coms3620.fashion.menus.logistics.manage_shipments;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Option;

public class ViewShipments implements Option {
    private LogisticsManager logisticsManager;

    public ViewShipments(LogisticsManager logisticsManager) {
        this.logisticsManager = logisticsManager;
    }

    @Override
    public String getName() {
        return "View shipments";
    }

    @Override
    public void run() {
        logisticsManager.viewShipments();
    }
    
}
