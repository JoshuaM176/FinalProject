package coms3620.fashion.departments.marketing_and_sales.adverts;

public class RadioAdvert extends Advert{
    public static String type = "Radio";

    public RadioAdvert() {
        super();
    }

    public RadioAdvert(Object[] object) {
        super(object);
    }

    public RadioAdvert(AdvertParameters params) {
        super(params);
    }

    public static String getType() {
        return "Radio";
    }
}
