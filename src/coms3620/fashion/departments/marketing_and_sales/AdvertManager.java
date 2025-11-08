package coms3620.fashion.departments.marketing_and_sales;
import coms3620.fashion.departments.marketing_and_sales.Adverts.Advert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AdvertManager {

    private List<Advert> adverts = new ArrayList<Advert>();
    private AdvertFactory advertFactory = new AdvertFactory();

    public void loadData() {} //TODO

    public void saveData() {} //TODO

    public void createAdvert() {
        Advert advert = advertFactory.createAdvertFromInput();
        if(Objects.isNull(advert)) {
            System.out.println("Advert creation cancelled");
        }
        else {
            adverts.add(advert);
        }
    }

    public void addAdvert(Advert advert) {
        adverts.add(advert);
    }

    public String toString() {
        String string = "pricePerDay, name, type, running, id\n";
        for(Advert advert : adverts) {
            string += advert.pricePerDay + ", "+ advert.name + ", " + advert.type + ", " + advert.getRunning() + ", " + advert.getId() + "\n";
        }
        return string;
    }

}

