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

    public void run() {
        System.out.println("\n============================= Available Products ==============================");
        System.out.printf("%-30s %-20s %-10s %-10s %-10s\n",
                "Name", "SKU", "Size", "Price", "Stock");
        System.out.println("-------------------------------------------------------------------------------");

        for (Product p : logisticsManager.getAllProducts()) {
            System.out.printf("%-30s %-20s %-10s $%-9.2f %-10d\n",
                    p.getName(),
                    p.getSKU(),
                    p.getSize(),
                    p.getPrice(),
                    p.getQuantity());
        }

        System.out.println("===============================================================================\n");
    }

}
