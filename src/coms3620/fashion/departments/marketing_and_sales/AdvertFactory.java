package coms3620.fashion.departments.marketing_and_sales;

import coms3620.fashion.departments.marketing_and_sales.adverts.*;
import coms3620.fashion.util.InputValidation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.Objects;


public class AdvertFactory {

    private Map<String,Supplier<Advert>> classMap = new HashMap<String,Supplier<Advert>>();

    public AdvertFactory() {
        classMap.put("Magazine Advert", ()->new MagazineAdvert());
        classMap.put("Radio Advert", ()->new RadioAdvert());
        classMap.put("TV Commercial", ()->new TVCommercial());
    }

    public void addOption(Advert advert) {
        //TODO
    }

    public Advert createAdvertFromInput() {
        System.out.println("What type of advertisement are you creating?");
        Supplier<Advert> advertConstructor = selectOption(classMap);
        if(Objects.isNull(advertConstructor)) {return null;}
        return advertConstructor.get();
    }

    private <T> T selectOption(Map<String,T> options) {
        String[] labels = new String[options.size()];
        int i = 0;
        System.out.println("0: Cancel");
        for(String label: options.keySet()) {
            System.out.println((i+1) +": " + label);
            labels[i] = label;
            i++;
        }
        int userInput = InputValidation.IntegerRangeInput(0, options.size());
        if(userInput == 0) {
            return null;
        }
        else {
            return options.get(labels[userInput-1]);
        }
    }

    
}
