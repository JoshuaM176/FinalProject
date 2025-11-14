package coms3620.fashion.departments.logistics;

import java.util.List;

import coms3620.fashion.departments.logistics.order.Order;
import coms3620.fashion.departments.logistics.order.OrderLine;
import coms3620.fashion.departments.logistics.order.OrderManager;
import coms3620.fashion.departments.logistics.shipment.ShipmentManager;

public class LogisticsManager {
    private final OrderManager orderManager;
    private final ShipmentManager shipmentManager;

    public LogisticsManager() {
        orderManager = new OrderManager();
        shipmentManager = new ShipmentManager();
    }

    public Order createOrder(List<OrderLine> ols) {
        return(orderManager.createOrder(ols));
    }

    public void viewOrders() {
        orderManager.viewOrders();
    }

    public void deleteOrder() {
        orderManager.deleteOrder();
    }

    public void printAvailableProducts() {
        orderManager.printAvailableProducts();
    }

    public void createShipment() {
        viewOrders();
        shipmentManager.createShipment(orderManager.getOrders());
    }

    public void viewShipments() {
        shipmentManager.viewShipments();
    }

    public OrderManager getOrderManager() {
        return this.orderManager;
    }
}
