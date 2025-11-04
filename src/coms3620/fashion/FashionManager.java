package coms3620.fashion;

import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.marketing_and_sales.MarketingAndSales;


public class FashionManager extends Menu {

    public FashionManager() {
        // Define options
        MarketingAndSales marketing_and_sales = new MarketingAndSales();
        // Add options
        addOption(marketing_and_sales);
    }
}