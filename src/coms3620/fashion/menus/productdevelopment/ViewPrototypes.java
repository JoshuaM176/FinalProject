package coms3620.fashion.menus.productdevelopment;

import coms3620.fashion.menus.Option;
import coms3620.fashion.departments.Product_Development.FileStorage;

import java.util.List;

public class ViewPrototypes implements Option {

    @Override
    public String getName() {
        return "View Prototypes";
    }

    @Override
    public void run() {
        try {
            FileStorage storage = new FileStorage("data/product_development/prototypes.txt");
            List<String> lines = storage.readAll();
            if (lines.isEmpty()) {
                System.out.println("No prototypes found.");
            } else {
                for (String line : lines) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading prototypes: " + e.getMessage());
        }
    }
}
