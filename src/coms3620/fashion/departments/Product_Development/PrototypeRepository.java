package coms3620.fashion.departments.product_development;

import coms3620.fashion.util.DataReader;
import coms3620.fashion.util.DataWriter;

import java.io.IOException;
import java.util.*;

public class PrototypeRepository {

    private final String filePath;
    private final List<Prototype> cache = new ArrayList<>();

    public PrototypeRepository(String filePath) {
        this.filePath = filePath;
        load();                       // eager load
    }

    /*  load from CSV  */
    private void load() {
        try (DataReader dr = new DataReader(filePath)) {
            dr.getRow("sssb");        // skip header
            Object[] row;
            while ((row = dr.getRow("usbb")) != null) { // UUID, String, String, boolean
                UUID id         = (UUID) row[0];
                String concept  = (String) row[1];
                String materials= (String) row[2];
                boolean approved= (Boolean) row[3];
                cache.add(new Prototype(id, concept, materials, approved));
            }
        } catch (Exception e) {
            System.out.println("No existing prototype file found—starting fresh.");
        }
    }

    /*  persist to CSV  */
    public void save() {
        try (DataWriter dw = new DataWriter(filePath)) {
            dw.putRow("id", "concept", "materials", "approved"); // header
            for (Prototype p : cache) dw.putRow(p.toRow());
        } catch (IOException e) {
            System.out.println("Failed to save prototypes: " + e.getMessage());
        }
    }

    /*  CRUD helpers  */
    public void add(Prototype p) { cache.add(p); save(); }
    public List<Prototype> findAll() { return Collections.unmodifiableList(cache); }
}