package coms3620.fashion.departments.Logistics;

public class Product {
    private String sku;
    private String upc;
    private int quantity;

    public Product(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }
    
    public String getSKU() {
        return this.sku;
    }

    public String getUPC() {
        return this.upc;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String toString() {
        return sku;
    }
}
