package coms3620.fashion.departments.logistics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import coms3620.fashion.departments.logistics.order.Order;
import coms3620.fashion.departments.logistics.order.OrderLine;
import coms3620.fashion.departments.logistics.shipment.Shipment;
import coms3620.fashion.util.RandStringGenerator;

public class LogisticsManager {
    private List<Order> orders;
    private List<Shipment> shipments;
    private final ProductRepository productRepository;
    private final RandStringGenerator randString;
    private Map<String, String> availableProducts;

    public LogisticsManager() {
        orders = new ArrayList<>();
        shipments = new ArrayList<>();
        productRepository = new ProductRepository("data/logistics/products.csv");
        randString = new RandStringGenerator();
        availableProducts = new HashMap<>();
    }

    public Order createOrder(List<OrderLine> ols) {
        Order order = new Order(randString.generateRandomString(8), ols);
        order.finalizeOrder();
        orders.add(order);

        return order;
    }

    public void createShipment() {
        String id = randString.generateRandomString(8);
        Shipment shipment = new Shipment(new ArrayList<>(orders), id);
        shipments.add(shipment);
        orders.clear();
    }

    public boolean containsProduct(String name) {
        return productRepository.containsProduct(name);
    }

    public boolean reduceProductQuantity(String name, int amount) {
        return productRepository.reduceProductQuantity(name, amount);
    }

    public Product getProductByName(String name) {
        return productRepository.getProductByName(name);
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public List<Shipment> getShipments() {
        return this.shipments;
    }

    public Collection<Product> getAllProducts() {
        return productRepository.getAll();
    }

    /**
     * TEMPORARY
     */
    public void printAvailableProducts() {
        availableProducts.clear();
        availableProducts.put("shirt", "TSH-M-BLK-NK-001");
        availableProducts.put("hat", "HAT-M-GRY-NK-001" );
        availableProducts.put("pants", "PNT-BLU-LEV-001");
        System.out.println("Avaliable products:");
        for (String key : availableProducts.keySet()) {
            System.out.println(key);
        }
        System.out.println();
    }

    public String getSKU(String name) {
        return availableProducts.get(name);
    }

    public boolean isValidInput(String name) {
        if (!availableProducts.containsKey(name)) 
            return false;
        else
            return true;
    }

    public boolean isValidInput(int quantity) {
        if (quantity <= 0) 
            return false;
        else
            return true;
    }
}