package coms3620.fashion;

import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.marketing_and_sales.MarketingAndSales;
import coms3620.fashion.menus.logistics.Logistics;
import coms3620.fashion.menus.human_resources.HumanResources;
import coms3620.fashion.menus.product_dev.ProductDevelopment;




public class FashionManager extends Menu {

    public FashionManager() {
        // Define options
        MarketingAndSales marketing_and_sales = new MarketingAndSales();
        Logistics logistics = new Logistics();
    ProductDevelopment productDev = new ProductDevelopment();
        // Add options
        addOption(marketing_and_sales);
        addOption(logistics);
    addOption(new HumanResources());
    addOption(productDev);
    }
}