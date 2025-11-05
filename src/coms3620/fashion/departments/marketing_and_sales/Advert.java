package coms3620.fashion.departments.marketing_and_sales;

import java.util.UUID;

public abstract class Advert {
    int price_per_day;
    String name;
    String type = "none";
    UUID id;
    boolean running = false;

    public Advert(int price_per_day, String name) {
        this.price_per_day = price_per_day;
        this.name = name;
        id = UUID.randomUUID();
    }
}
