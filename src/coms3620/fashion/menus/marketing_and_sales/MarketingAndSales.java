package coms3620.fashion.menus.marketing_and_sales;

import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.Option;

public class MarketingAndSales extends Menu implements Option {

    public MarketingAndSales() {
        // Define options
        ViewBudget view_budget = new ViewBudget();
        CreateAdvert createAdvert = new CreateAdvert();
        // Add options
        addOption(view_budget);
        addOption(createAdvert);
    }

    @Override
    public String getName() {
        return "Marketing and Sales";
    }

    @Override
    public void run() {
        enter_menu();
    }
}
