package coms3620.fashion.menus.marketing_and_sales;

import coms3620.fashion.menus.Option;
import coms3620.fashion.departments.marketing_and_sales.AdvertManager;

public class CreateAdvert implements Option {

    @Override
    public String getName() {
        return "Create Advert";
    }

    @Override
    public void run() {
        AdvertManager advertManager = new AdvertManager();
        advertManager.loadData();
        advertManager.createAdvert();
        advertManager.saveData();
    }
    
}
