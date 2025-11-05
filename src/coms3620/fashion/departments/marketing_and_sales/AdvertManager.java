package coms3620.fashion.departments.marketing_and_sales;
import coms3620.fashion.util.Stdin;
import coms3620.fashion.util.InputValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AdvertManager {

    List<Advert> adverts = new ArrayList<Advert>();

    public void loadData() {} //TODO

    public void saveData() {} //TODO

    public void createAdvert() {
        System.out.println("What kind of advertisement are you creating?");
        String[] options = {"Magazine Advert", "Radio Advert", "TV Commercial"};
        int advert_choice = InputValidation.OptionsInput(options);
        System.out.println("What is the name of the new advertisement: ");
        String name = Stdin.nextLine();
        System.out.println("What is the price per day of the advertisement: ");
        int price_per_day = InputValidation.IntegerMinInput(0);
        switch (options[advert_choice]) {
            case "Magazine Advert":
                adverts.add(new MagazineAdvert(price_per_day, name));
                break;
            case "Radio Advert":
                adverts.add(new RadioAdvert(price_per_day, name));
                break;
            case "TV Commercial":
                adverts.add(new TVCommerical(price_per_day, name));
                break;
        }
    }
    
    private abstract class Advert {
        int price_per_day;
        String name;
        String type = "none";
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
            type = "Magazine";
        }
    }

    private class RadioAdvert extends Advert {
        private RadioAdvert(int price_per_day, String name) {
            super(price_per_day, name);
            type = "Radio";
        }
    }

    private class TVCommerical extends Advert {
        private TVCommerical(int price_per_day, String name) {
            super(price_per_day, name);
            type = "TV";
        }
    }

    public String toString() {
        String string = "price_per_day, name, type, running, id\n";
        for(Advert advert : adverts) {
            string += advert.price_per_day + ", "+ advert.name + ", " + advert.type + ", " + advert.running + ", " + advert.id;
        }
        return string;
    }

}

