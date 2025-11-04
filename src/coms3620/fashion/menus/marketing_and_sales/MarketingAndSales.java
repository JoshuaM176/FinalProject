package coms3620.fashion.menus.marketing_and_sales;

import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.Option;
import coms3620.fashion.menus.marketing_and_sales.ViewBudget;

public class MarketingAndSales extends Menu implements Option {

    public MarketingAndSales() {
        // Define options
        ViewBudget view_budget = new ViewBudget();
        // Add options
        addOption(view_budget);
    }

    @Override
    public String get_name() {
        return "Marketing and Sales";
    }

    @Override
    public void run() {
        enter_menu();
    }
}
