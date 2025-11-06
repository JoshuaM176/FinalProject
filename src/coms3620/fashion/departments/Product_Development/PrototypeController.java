package coms3620.fashion.departments.Product_Development;

public class PrototypeController {
    private final MaterialManager materialManager;
    private final Storage storage;

    public PrototypeController(MaterialManager materialManager, Storage storage) {
        this.materialManager = materialManager;
        this.storage = storage;
    }

    public void createPrototype(String concept, String materials, String requestedBy) {
        // 1) check materials (Alt flow if false)
        if (!materialManager.available(materials)) {
            System.out.println("ERROR: Materials unavailable. Canceling request.");
            return;
        }
        // 2) create prototype
        Prototype p = new Prototype(concept, materials);
        p.approve(); // keep Iteration 1 simple

        // 3) save to file
        try {
            storage.write("[Prototype] " + p.toRecord() + " | requestedBy=" + requestedBy);
            System.out.println("OK: Prototype created and saved.");
        } catch (Exception e) {
            System.out.println("ERROR: Failed to save prototype: " + e.getMessage());
        }
    }
}
