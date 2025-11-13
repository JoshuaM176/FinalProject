package coms3620.fashion.menus.productdevelopment;

import coms3620.fashion.departments.product_development.FileStorage;
import coms3620.fashion.departments.product_development.MaterialManager;
import coms3620.fashion.departments.product_development.PrototypeController;
import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.Option;

public class ManagePrototypes extends Menu implements Option {

    public ManagePrototypes() {
        PrototypeController controller = new PrototypeController(
                new MaterialManager(),
                new FileStorage("data/product_development/prototypes.txt")
        );

        addOption(new CreatePrototype(controller));
        addOption(new ViewPrototypes());
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
