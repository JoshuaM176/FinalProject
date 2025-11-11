package coms3620.fashion.departments.Product_Development;

import java.util.List;

/**
 * Manager for Product Development operations.
 * Handles prototype creation and retrieval (follows AdvertManager pattern).
 */
public class ProductDevManager {
    private final MaterialManager materialManager;
    private final Storage storage;
    private final PrototypeController controller;

    public ProductDevManager() {
        this.materialManager = new MaterialManager();
        this.storage = new FileStorage("prototypes.txt");
        this.controller = new PrototypeController(materialManager, storage);
    }

    /**
     * Create a new prototype.
     */
    public void createPrototype(String concept, String materials, String designerName) {
        ProductDesigner designer = new ProductDesigner(designerName);
        designer.requestPrototype(controller, concept, materials);
        System.out.println("Prototype creation request processed.");
    }

    /**
     * View all saved prototypes.
     */
    public void viewPrototypes() {
        try {
            List<String> lines = storage.readAll();
            if (lines.isEmpty()) {
                System.out.println("No prototypes saved yet.");
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
