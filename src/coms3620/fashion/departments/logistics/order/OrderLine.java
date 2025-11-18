package coms3620.fashion.departments.logistics.order;

import coms3620.fashion.departments.logistics.Product;

public class OrderLine {
    private final Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProductName() {
        return product.getName();
    }

    public String getProductSku() {
        return product.getSKU();
    }

    public int getQuantity() {
        return this.quantity;
    }
}
