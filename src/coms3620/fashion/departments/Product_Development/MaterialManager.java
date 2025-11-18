package coms3620.fashion.departments.Product_Development;

public class MaterialManager {
    // Rudimentary material availability check
    public boolean available(String materials) {
        return materials != null && !materials.trim().isEmpty();
    }
}
