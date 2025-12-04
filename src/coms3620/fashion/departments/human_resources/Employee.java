package coms3620.fashion.departments.human_resources;

public class Employee {
    private int id;
    private String name;
    private RoleLevel roleLevel;
    private String location;
    private String title;
    private int salary;


public Employee(int id, String name, RoleLevel roleLevel, String location, String title, int salary) {
    this.id = id;
    this.name = name;
    this.roleLevel = roleLevel;
    this.location = location;
    this.title = title;
    this.salary = salary;
}

public enum RoleLevel {
    JUNIOR,
    SENIOR,
    MANAGER
    }







    public int getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getTitle() { return title; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }
    public RoleLevel getRoleLevel(){ return roleLevel; }
    public void setRoleLevel(RoleLevel roleLevel){ this.roleLevel = roleLevel; }

    public void fire(String reason) {
        System.out.println("Employee " + name + " has been fired for: " + reason);
    }

    @Override
    public String toString() {
        return id + "," + name;
    }

    
}



