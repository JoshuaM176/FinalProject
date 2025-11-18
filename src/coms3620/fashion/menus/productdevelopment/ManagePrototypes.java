package coms3620.fashion.menus.productdevelopment;

import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.Option;
import coms3620.fashion.departments.Product_Development.*;

public class ManagePrototypes extends Menu implements Option {

    public ManagePrototypes() {
        // 1. create the repository and controller once
        PrototypeRepository repo       = new PrototypeRepository("data/product_development/prototypes.csv");
        PrototypeController controller = new PrototypeController(new MaterialManager(), repo);

        // 2. pass them to the menu options that need them
        addOption(new CreatePrototype(controller));
        addOption(new ViewPrototypes(repo));
    }

    @Override
    public String getName() { 
        return "Manage Prototypes"; 
    }

    @Override
    public void run() { 
        enter_menu(); 
    }
}