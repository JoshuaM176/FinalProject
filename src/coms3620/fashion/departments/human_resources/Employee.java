package coms3620.fashion.departments.human_resources;

public class Employee {
    private int id;
    private String name;
    private String level;
    private String location;
    private String title;
    private int salary;

public Employee(int id, String name, String level, String location, String title, int salary) {
    this.id = id;
    this.name = name;
    this.level = level;
    this.location = location;
    this.title = title;
    this.salary = salary;
}




    public int getId() { return id; }
    public String getName() { return name; }
    public String getLevel() { return level; }
    public String getLocation() { return location; }
    public String getTitle() { return title; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public void fire(String reason) {
        System.out.println("Employee " + name + " has been fired for: " + reason);
    }

    @Override
    public String toString() {
        return id + "," + name;
    }

    
}

