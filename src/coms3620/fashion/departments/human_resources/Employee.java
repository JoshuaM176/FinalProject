package coms3620.fashion.departments.human_resources;

public class Employee {
    private int id;
    private String name;
    private String status; // "Active" or "Terminated"

public Employee(int id, String name, String status) {
    this.id = id;
    this.name = name;
    this.status = status;
}


    public int getId() { return id; }
    public String getName() { return name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void fire(String reason) {
        if (status.equalsIgnoreCase("Terminated")) {
            System.out.println(name + " is already terminated.");
            return;
        }
        status = "Terminated";
        System.out.println("Employee " + name + " has been fired for: " + reason);
    }

    @Override
    public String toString() {
        return id + "," + name + "," + status;
    }

    
}

