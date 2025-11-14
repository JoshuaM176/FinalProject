package coms3620.fashion.departments.logistics;


public interface Trackable {

    public enum Status {
        PENDING, SHIPPED, EARLY, LATE, DELIVERED, CANCELED
    }
    public String getID();
    public String getStatus();
    public void updateStatus(Status status);
}
