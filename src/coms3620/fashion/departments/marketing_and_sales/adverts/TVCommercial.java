package coms3620.fashion.departments.marketing_and_sales.adverts;

public class TVCommercial extends Advert{
    public static String type = "TVCommercial";

    public TVCommercial() {
        super();
    }

    public TVCommercial(Object[] object) {
        super(object);
    }

    public TVCommercial(AdvertParameters params) {
        super(params);
    }

    public static String getType() {
        return "TV";
    }
}
