package coms3620.fashion.departments.marketing_and_sales.adverts;

import java.util.UUID;

public interface Publishable{

    public String getName();
    public String getType();
    public UUID getId();
    public int getQuarterlyCost();
    public String getMedia();

}
