package coms3620.fashion.departments.marketing_and_sales.Adverts;
import coms3620.fashion.util.InputValidation;
import coms3620.fashion.util.Stdin;
import java.util.UUID;

public abstract class Advert {

    public int pricePerDay;
    public String name;
    public String type = "none";
    private UUID id;
    private boolean running = false;

    public Advert(int pricePerDay, String name) {
        this.pricePerDay = pricePerDay;
        this.name = name;
        id = UUID.randomUUID();
    }

    public Advert(AdvertParameters params) {
        this(params.pricePerDay, params.name);
    }

    public Advert() {
        AdvertParameters params = new AdvertParameters();
        this.pricePerDay = params.pricePerDay;
        this.name = params.name;
        id = UUID.randomUUID();
    }

    public class AdvertParameters {
        int pricePerDay;
        String name;

        public AdvertParameters(int pricePerDay, String name) {
            this.pricePerDay = pricePerDay;
            this.name = name;
        }

        public AdvertParameters() {
            System.out.println("Enter the price per day of the advertisement.");
            this.pricePerDay = InputValidation.IntegerMinInput(0);
            System.out.println("Enter the name of the advertisement.");
            this.name = Stdin.nextLine();
        }
    }

    public UUID getId() {
        return id;
    }

    public boolean getRunning() {
        return running;
    }

}


