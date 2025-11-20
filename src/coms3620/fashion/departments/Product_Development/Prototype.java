package coms3620.fashion.departments.product_development;

import java.util.UUID;

public class Prototype {

    private final UUID id;
    private final String conceptName;
    private final String materials;
    private boolean approved;

    public Prototype(String conceptName, String materials) {
        if (conceptName == null || conceptName.isBlank()) {
            throw new IllegalArgumentException("conceptName must not be null or blank");
        }
        if (materials == null || materials.isBlank()) {
            throw new IllegalArgumentException("materials must not be null or blank");
        }
        this.id = UUID.randomUUID();
        this.conceptName = conceptName;
        this.materials = materials;
        this.approved = false;
    }

    public Prototype(UUID id, String conceptName, String materials, boolean approved) {
        this.id = id;
        this.conceptName = conceptName;
        this.materials = materials;
        this.approved = approved;
    }

    public void approve() {
        this.approved = true;
    }

    public void unapprove() {
        this.approved = false;
    }

    public Object[] toRow() {
        return new Object[]{id, conceptName, materials, approved};
    }

    @Override
    public String toString() {
        return String.format(
                "Prototype{id=%s, concept='%s', materials='%s', approved=%s}",
                id, conceptName, materials, approved
        );
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getConceptName() {
        return conceptName;
    }

    public String getMaterials() {
        return materials;
    }

    public boolean isApproved() {
        return approved;
    }
}
