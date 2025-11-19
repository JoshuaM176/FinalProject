package coms3620.fashion.departments.product_development;

import coms3620.fashion.util.DataReader;
import coms3620.fashion.util.DataWriter;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PrototypeRepository {

    private final String filePath;
    private final List<Prototype> cache = new ArrayList<>();

    public PrototypeRepository(String filePath) {
        this.filePath = filePath;
        File f = new File(filePath);
        if (f.exists() && f.length() > 0) {
            load();                       // read only when there is data
        } else {
            System.out.println("Repository: no existing CSV (“" + filePath + "”) – starting empty.");
        }
    }

    /*  load from CSV  */
    private void load() {
        try (DataReader dr = new DataReader(filePath)) {
            dr.getRow("ssss");        // skip header
            Object[] row;
            while ((row = dr.getRow("ussb")) != null) {
                // ----  add this block  ----
                for (int i = 0; i < row.length; i++) {
                    System.out.printf("col-%d class=%-7s value=%s%n", i, row[i].getClass().getSimpleName(), row[i]);
                }
                // --------------------------
                UUID id = (UUID) row[0];
                String concept = (String) row[1];
                String materials = (String) row[2];
                boolean approved = (Boolean) row[3];
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
            for (Prototype p : cache) {
                dw.putRow(p.toRow());
            }
        } catch (IOException e) {
            System.out.println("Failed to save prototypes: " + e.getMessage());
        }
    }

    public void add(Prototype p) {
        cache.add(p);
        save();
    }

    public List<Prototype> findAll() {
        System.out.println("CACHE before return:");
        for (Prototype p : cache) {
            System.out.printf("  %s  approved=%s%n", p.getId(), p.isApproved());
        }
        return Collections.unmodifiableList(cache);
    }
}
