package coms3620.fashion.departments.product_development;

import java.time.LocalDateTime;
import java.util.UUID;

public class Prototype {
    private final UUID id;
    private final String conceptName;
    private final String materials;
    private boolean approved;

    public Prototype(String conceptName, String materials) {
        this.id = UUID.randomUUID();
        this.conceptName = conceptName;
        this.materials = materials;
        this.approved = false;
    }

    /*  for re-hydrating from CSV  */
    public Prototype(UUID id, String conceptName, String materials, boolean approved) {
        this.id = id;
        this.conceptName = conceptName;
        this.materials = materials;
        this.approved = approved;
    }

    public void approve() { this.approved = true; }

    /*  CSV row:  u,s,s,b   (UUID, concept, materials, approved)  */
    public Object[] toRow() {
        return new Object[]{id, conceptName, materials, approved};
    }

    public String toRecord() {
        return String.format(
            "id=%s | concept=%s | materials=%s | approved=%s | ts=%s",
            id, conceptName, materials, approved, LocalDateTime.now()
        );
    }

    /*  getters  */
    public UUID getId() { return id; }
    public String getConceptName() { return conceptName; }
    public String getMaterials() { return materials; }
    public boolean isApproved() { return approved; }
}