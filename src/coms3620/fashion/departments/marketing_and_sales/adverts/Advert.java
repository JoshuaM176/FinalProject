package coms3620.fashion.departments.marketing_and_sales.adverts;
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

    public Advert(Object[] object) {
        try {
            type = (String)object[0];
            name = (String)object[1];
            pricePerDay = (int)object[2];
            running = (boolean)object[3];
            id = (UUID)object[4];
        } catch (Exception e) {
            System.out.println("Failed to create object");
        }

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

    public void setId(UUID id) {   
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public boolean getRunning() {
        return running;
    }

}


