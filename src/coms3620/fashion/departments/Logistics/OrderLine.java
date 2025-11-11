package coms3620.fashion.departments.logistics;

public class OrderLine {
    private String name;
    private String sku;
    private String upc;
    private int quantity;

    public OrderLine(String name, String sku, int quantity) {
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    
    public String getSKU() {
        return this.sku;
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        return name + " (" + sku + ")";
    }
}
