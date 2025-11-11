package coms3620.fashion;

import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.Option;
import coms3620.fashion.Product_Development.ProductDevMain;

/**
 * Small launcher that demonstrates using the existing ProductDevMain via the Menu system.
 * It builds an in-memory menu with a single option that runs the Product Development demo.
 */
public class MainProductDev {
    public static void main(String[] args) {
        Menu menu = new Menu() {};

        menu.addOption(new Option() {
            @Override
            public String getName() {
                return "Run Product Development Demo";
            }

            @Override
            public void run() {
                // Delegate to the existing demo main
                ProductDevMain.main(new String[0]);
            }
        });

        // Enter the menu loop (0 to exit)
        menu.enter_menu();
    }
}
