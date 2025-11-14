package coms3620.fashion.departments.logistics;

import java.util.ArrayList;
import java.util.List;

import coms3620.fashion.departments.logistics.order.OrderLine;
import coms3620.fashion.misc.RandStringGenerator;

public class Test {

    public static void main(String[] args) {
        LogisticsManager logisticsManager = new LogisticsManager();
        OrderLine ol = new OrderLine("shirt", "TSH-M-BLK-NK-001", 2);
        List<OrderLine> ols= new ArrayList();
        ols.add(ol);
        RandStringGenerator rand = new RandStringGenerator();

        logisticsManager.createOrder(ols, rand.generateRandomString(6));
        logisticsManager.createOrder(ols, rand.generateRandomString(6));
        logisticsManager.viewOrders();
        logisticsManager.createShipment();
        logisticsManager.viewShipments();
        
    }
}
