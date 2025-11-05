package coms3620.fashion.menus.marketing_and_sales.manage_adverts;

import coms3620.fashion.departments.marketing_and_sales.AdvertManager;
import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.Option;

public class ManageAdverts extends Menu implements Option{

    public ManageAdverts() {
        AdvertManager advertManager = new AdvertManager();
        advertManager.loadData();
        // Define Options
        ViewAdverts viewAdverts = new ViewAdverts(advertManager);
        CreateAdvert createAdvert = new CreateAdvert(advertManager);
        // Add Options
        addOption(viewAdverts);
        addOption(createAdvert);
    }

    @Override
    public String getName() {
        return "Manage Adverts";
    }

    @Override
    public void run() {
        enter_menu();
    }
    
}
