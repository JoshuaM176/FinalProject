package coms3620.fashion.departments.marketing_and_sales;

import coms3620.fashion.departments.marketing_and_sales.adverts.*;
import coms3620.fashion.util.InputValidation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.DrbgParameters.Instantiation;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.Objects;


public class AdvertFactory {

    private Map<String,Supplier<Advert>> advertFromInputMap = new HashMap<String,Supplier<Advert>>();
    private Map<String,Function<Object[],Advert>> advertFromFileMap = new HashMap<String,Function<Object[],Advert>>();

    public AdvertFactory(){
        //Define constructors for user input
        advertFromInputMap.put("Magazine Advert", ()->new MagazineAdvert());
        advertFromInputMap.put("Radio Advert", ()->new RadioAdvert());
        advertFromInputMap.put("TV Commercial", ()->new TVCommercial());
        //Define constructors for reading from file
        advertFromFileMap.put("Magazine", (Object[] object)->new MagazineAdvert(object));
        advertFromFileMap.put("Radio", (Object[] object)->new RadioAdvert(object));
        advertFromFileMap.put("TV", (Object[] object)->new TVCommercial(object));
    }

    public <T extends Advert> void addOption(Class<T> advert, String displayName, String type){
        //TODO
    }

    public Advert createAdvertFromInput() {
        System.out.println("What type of advertisement are you creating?");
        Supplier<Advert> advertConstructor = selectOption(advertFromInputMap);
        if(Objects.isNull(advertConstructor)) {return null;}
        return advertConstructor.get();
    }

    public Advert createAdvertFromObject(Object[] object) {
        Function<Object[],Advert> function = advertFromFileMap.get(object[0]);
        Advert advert = function.apply(object);
        return advert;
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
