package coms3620.fashion.departments.logistics;

import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.Policy;
import java.util.Collection;
import java.util.HashMap;

public class ProductRepository {
    private Map<String, Product> products = new HashMap<>();

    public ProductRepository(String filepath) {
        loadProducts(filepath);
    }

    private void loadProducts(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                String name = parts[0].trim();
                String sku = parts[1].trim();
                String size = parts[2].trim();
                double price = Double.parseDouble(parts[3].trim());
                int quantity = Integer.parseInt(parts[4].trim());

                Product p = new Product(name, sku, size, price, quantity);
                products.put(name, p);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load product file: " + filepath, e);
        }
    }

    public Product getProductByName(String name) {
        return products.get(name);
    }

    public boolean reduceProductQuantity(String name, int quantity) {
        return products.get(name).reduceQuantity(quantity);
    }

    public boolean containsProduct(String name) {
        return products.containsKey(name);
    }

    public Collection<Product> getAll() {
        return products.values();
    }

}
