package coms3620.fashion.departments.logistics;

import java.util.List;

import coms3620.fashion.departments.logistics.order.OrderLine;
import coms3620.fashion.departments.logistics.order.OrderManager;
import coms3620.fashion.departments.logistics.shipment.ShipmentManager;

public class LogisticsManager {
    private final OrderManager orderManager;
    private final ShipmentManager shipmentManager;

    public LogisticsManager() {

        shipmentManager = new ShipmentManager();
        orderManager = new OrderManager();
    }

    public void createOrder() {
        orderManager.createOrder();
    }

    public void createOrder(List<OrderLine> ols, String id) {
        orderManager.createOrder(ols, id);
    }

    public void viewOrders() {
        orderManager.viewOrders();
    }

    public void deleteOrder() {
        orderManager.deleteOrder();
    }

    public void createShipment() {
        viewOrders();
        shipmentManager.createShipment(orderManager.getOrders());
    }

    public void viewShipments() {
        shipmentManager.viewShipments();
    }
}
