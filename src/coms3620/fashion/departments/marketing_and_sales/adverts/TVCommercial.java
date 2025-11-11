package coms3620.fashion.departments.marketing_and_sales.adverts;

public class TVCommercial extends Advert{
    public TVCommercial() {
        super();
        type = "TV";
    }

    public TVCommercial(Object[] object) {
        super(object);
    }

    public TVCommercial(AdvertParameters params) {
        super(params);
    }
}
