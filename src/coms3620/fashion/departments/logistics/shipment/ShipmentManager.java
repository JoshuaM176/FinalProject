package coms3620.fashion.departments.logistics.shipment;

import java.util.ArrayList;
import java.util.List;

import coms3620.fashion.departments.logistics.order.Order;
import coms3620.fashion.util.RandStringGenerator;
import coms3620.fashion.util.Stdin;

public class ShipmentManager {
    private List<Shipment> shipments;
    private final RandStringGenerator randString;

    public ShipmentManager() {
        shipments = new ArrayList<>();
        randString = new RandStringGenerator();
    }

    public void createShipment(List<Order> orders) {
        if (orders.isEmpty())
            return;
        else {
            System.out.println("Ship these orders?");
            System.out.print("(1 = yes, 2 = no) --> ");
            int shipOrders = Stdin.nextInt();
            // int shipOrders = 1;

            if (shipOrders != 1)
                return;
            else {
                Shipment shipment = new Shipment(new ArrayList<>(orders), randString.generateRandomString(8));
                shipments.add(shipment);
                orders.clear();
            }
        }
    }

    public void viewShipments() {
        System.out.println();
        if (shipments.isEmpty())
            System.out.println("There are currently no shipments");
        else {
            int index = 1;
            for (Shipment shipment : shipments) {
                System.out.println("Shipment no. " + index);
                System.out.println(shipment.generateInvoice());
                index++;
            }
        }
    }

}
