package coms3620.fashion.departments.marketing_and_sales.adverts;

public class MagazineAdvert extends Advert {

    public MagazineAdvert() {
        super();
    }

    public MagazineAdvert(Object[] object) {
        super(object);
    }

    public MagazineAdvert(AdvertParameters params) {
        super(params);
    }

    public static String getType() {
        return "Magazine";
    }
}
