package coms3620.fashion.menus.product_dev;

import java.util.List;

public class ProductDevMain {
    public static void main(String[] args) {
        // Initialize components 
        MaterialManager materialManager = new MaterialManager();
        Storage storage = new FileStorage("prototypes.txt");
        PrototypeController controller = new PrototypeController(materialManager, storage);

        // Simulate actor
        ProductDesigner alex = new ProductDesigner("Alex T");

        // Execute use case
        alex.requestPrototype(controller, "Winter Jacket", "Polyester, Wool");

        // Print last saved prototype for verification
        try {
            List<String> lines = storage.readAll();
            if (!lines.isEmpty()) {
                System.out.println("\n--- Prototype Record Saved ---");
                System.out.println(lines.get(lines.size() - 1));
                System.out.println("-------------------------------");
            } else {
                System.out.println("No prototype records found.");
            }
        } catch (Exception e) {
            System.out.println("Error reading saved prototypes: " + e.getMessage());
        }

        System.out.println("\nProduct Development subsystem executed successfully!");
    }
}