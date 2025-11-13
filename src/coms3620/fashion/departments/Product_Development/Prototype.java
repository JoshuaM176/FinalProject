package coms3620.fashion.departments.product_development;

import java.time.LocalDateTime;
import java.util.UUID;

public class Prototype {
    private final String id;
    private final String conceptName;
    private final String materials;
    private boolean approved;

    public Prototype(String conceptName, String materials) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.conceptName = conceptName;
        this.materials = materials;
        this.approved = false;
    }

    public void approve() { this.approved = true; }

    public String toRecord() {
        return String.format(
            "id=%s | concept=%s | materials=%s | approved=%s | ts=%s",
            id, conceptName, materials, approved, LocalDateTime.now()
        );
    }
}
