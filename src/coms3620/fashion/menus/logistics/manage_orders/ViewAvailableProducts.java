package coms3620.fashion.menus.logistics.manage_orders;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.departments.logistics.Product;
import coms3620.fashion.menus.Option;

public class ViewAvailableProducts implements Option {
    private LogisticsManager logisticsManager;

    public ViewAvailableProducts(LogisticsManager logisticsManager) {
        this.logisticsManager = logisticsManager;
    }

    @Override
    public String getName() {
        return "View Avaiable Products";
    }

    public void productFormatter(Product p, int index) {
        System.out.printf(index +") %-30s %-20s %-10s $%-9.2f %-10d\n",
                    p.getName(),
                    p.getSKU(),
                    p.getSize(),
                    p.getPrice(),
                    p.getQuantity());
    }

    public void run() {
        System.out.println("\n=============================== Available Products ================================");
        System.out.printf("%-33s %-20s %-10s %-10s %-10s\n",
                "Name", "SKU", "Size", "Price", "Stock");
        System.out.println("-----------------------------------------------------------------------------------");
        int index = 1;
        for (Product p : logisticsManager.getAllProducts()) {
            productFormatter(p, index);
        }

        System.out.println("===================================================================================\n");
    }

}
