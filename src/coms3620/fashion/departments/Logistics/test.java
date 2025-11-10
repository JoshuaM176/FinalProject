package coms3620.fashion.departments.logistics;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        OrderLine shirts = new OrderLine("Shirt", "1", 6);
        OrderLine hats = new OrderLine("hat", "0", 2);
        OrderLine pants = new OrderLine("pants", "9", 4);

        List<OrderLine> A = new ArrayList<>();
        A.add(shirts);
        A.add(hats);

        List<OrderLine> A2 = new ArrayList<>();
        A2.add(pants);
        A2.add(hats);

        Order o = new Order(null, A);
        Order o2 = new Order(null, A2);


        Shipment s = new Shipment("42069");
        s.addOrder(o);
        s.addOrder(o2);
        s.finalizeShipment();

        System.out.println(s);
        
    }
    
}
