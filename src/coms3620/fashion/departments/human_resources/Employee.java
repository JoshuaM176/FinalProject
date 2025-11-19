package coms3620.fashion.departments.human_resources;

public class Employee {
    private int id;
    private String name;

public Employee(int id, String name) {
    this.id = id;
    this.name = name;
}


    public int getId() { return id; }
    public String getName() { return name; }

    public void fire(String reason) {
        System.out.println("Employee " + name + " has been fired for: " + reason);
    }

    @Override
    public String toString() {
        return id + "," + name;
    }

    
}

