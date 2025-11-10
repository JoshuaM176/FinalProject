package coms3620.fashion.departments.logistics;

import java.util.List;

public interface Repository {
    public void save (Object o);
    public Shipment findByID(String id);
    public List<Object> findAll();
}
