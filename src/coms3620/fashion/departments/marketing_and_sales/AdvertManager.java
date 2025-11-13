package coms3620.fashion.departments.marketing_and_sales;
import coms3620.fashion.departments.marketing_and_sales.adverts.Advert;
import coms3620.fashion.util.DataWriter;
import coms3620.fashion.util.DataReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AdvertManager {

    private List<Advert> adverts = new ArrayList<Advert>();
    private AdvertFactory advertFactory = new AdvertFactory();

    public void loadData() {
        try {
            DataReader reader = new DataReader("data/marketing_and_sales/adverts.csv");
            reader.getEncodedRow(); // Skip header
            Object[] object;
            while((object = reader.getEncodedRow()) != null) {
                Advert advert = advertFactory.createAdvertFromObject(object);
                adverts.add(advert);
            }
            reader.close();
        }
        catch(FileNotFoundException e) {}
        catch (Exception e) {
            System.out.println("Failed to read data");
            System.out.println(e);
        }
    }

    public void saveData() {
        try {
            DataWriter writer = new DataWriter("data/marketing_and_sales/adverts.csv");
            writer.putRow("sssss", "type", "name", "pricePerDay", "running", "id");
            for(Advert advert : adverts) {
                writer.putRow(advert.getRowData());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to save data");
            System.out.println(e);
        }
        
    }

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
            string += advert.pricePerDay + ", "+ advert.name + ", " + advert.getType() + ", " + advert.getRunning() + ", " + advert.getId() + "\n";
        }
        return string;
    }

}

