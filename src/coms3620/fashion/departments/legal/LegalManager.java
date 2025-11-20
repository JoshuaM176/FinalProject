package coms3620.fashion.departments.legal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import coms3620.fashion.departments.marketing_and_sales.adverts.AdvertisingRelationship;
import coms3620.fashion.departments.marketing_and_sales.adverts.PublishedAdvert;
import coms3620.fashion.util.DataReader;
import coms3620.fashion.util.DataWriter;

public class LegalManager {

    private List<PublishedAdvert> publishedAdverts = new ArrayList<PublishedAdvert>();
    private List<AdvertisingRelationship> advertisingRelationships = new ArrayList<AdvertisingRelationship>();
    

    public void loadData() {
        try {

            Object[] object;
            publishedAdverts = new ArrayList<PublishedAdvert>();
            DataReader reader = new DataReader("data/marketing_and_sales/publishedAdverts.csv");
            while((object = reader.getEncodedRow()) != null) {
                PublishedAdvert publishedAdvert = new PublishedAdvert(object);
                publishedAdverts.add(publishedAdvert);
            }
            reader.close();

            advertisingRelationships = new ArrayList<AdvertisingRelationship>();
            reader = new DataReader("data/marketing_and_sales/advertisingRelationships.csv");
            while((object = reader.getEncodedRow()) != null) {
                AdvertisingRelationship advertisingRelationship = new AdvertisingRelationship(object);
                advertisingRelationships.add(advertisingRelationship);
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
            DataWriter writer = new DataWriter("data/marketing_and_sales/publishedAdverts.csv");
            for(PublishedAdvert publishedAdvert : publishedAdverts) {
                writer.putRow(publishedAdvert.getRowData());
            }
            writer.close();

            writer = new DataWriter("data/marketing_and_sales/advertisingRelationships.csv");
            for(AdvertisingRelationship advertisingRelationship : advertisingRelationships) {
                writer.putRow(advertisingRelationship.getRowData());
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Failed to save data");
            System.out.println(e);
        }
        
    }

    public void approveAdvert() {
        // TODO
    }
}