package coms3620.fashion.menus.logistics.manage_shipments;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Option;
import coms3620.fashion.menus.logistics.manage_orders.ViewOrders;
import coms3620.fashion.util.Stdin;

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
        new ViewOrders(logisticsManager).run();
        if (logisticsManager.getOrders().isEmpty())
            return;
        else {
            System.out.println("Ship these orders?");
            System.out.print("(1 = yes, 2 = no) --> ");
            int shipOrders = Stdin.nextInt();
            if (shipOrders != 1)
                return;
            else {
                logisticsManager.createShipment();
            }
        }
    }
}
