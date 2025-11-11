package coms3620.fashion.departments.marketing_and_sales.adverts;

public class MagazineAdvert extends Advert {
    public MagazineAdvert() {
        super();
        type = "Magazine";
    }

    public MagazineAdvert(Object[] object) {
        super(object);
    }

    public MagazineAdvert(AdvertParameters params) {
        super(params);
    }
}
