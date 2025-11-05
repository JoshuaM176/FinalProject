package coms3620.fashion.departments.Logistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        Product p1 = new Product("product", 4);
        Product p2 = new Product("alsoProduct", 2);

        List<Product> A = new ArrayList<>();
        A.add(p1);
        A.add(p2);

        Order o = new Order("", A);

        Shipment s = new Shipment(null);
        s.addOrder(o);
        s.addOrder(o);
        s.finalizeShipment();

        Map<Product, Integer> products = s.getProducts();

        System.out.println(products);
        
    }
    
}
