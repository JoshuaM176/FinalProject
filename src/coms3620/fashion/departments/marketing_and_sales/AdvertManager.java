package coms3620.fashion.departments.marketing_and_sales;
import coms3620.fashion.util.Stdin;
import coms3620.fashion.util.InputValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AdvertManager {

    List<Advert> adverts = new ArrayList<Advert>();

    public void loadData() {}

    public void saveData() {}

    public void createAdvert() {
        System.out.println("What is the name of the new advertisement: ");
        String name = Stdin.nextLine();
        System.out.println("What is the price per day of the advertisement: ");
        int price_per_day = InputValidation.IntegerMinInput(0);
    }
    
    private abstract class Advert {

        int price_per_day;
        String name;
        UUID id;
        boolean running = false;

        private Advert(int price_per_day, String name) {
            this.price_per_day = price_per_day;
            this.name = name;
            id = UUID.randomUUID();
        }

    }

    private class MagazineAdvert extends Advert {
        private MagazineAdvert(int price_per_day, String name) {
            super(price_per_day, name);
        }
    }

    private class RadioAdvert extends Advert {
        private RadioAdvert(int price_per_day, String name) {
            super(price_per_day, name);
        }
    }

    private class TVCommerical extends Advert {
        private TVCommerical(int price_per_day, String name) {
            super(price_per_day, name);
        }
    }

}

