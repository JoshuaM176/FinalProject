package coms3620.fashion.departments.human_resources;
import java.io.*;
import java.util.*;

public class StoreManager {
    private List<Employee> employees = new ArrayList<>();
    private static final String FILE_NAME = "src/employee.csv";

    // Load employees from CSV
    public void loadEmployees() {
        employees.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String status = data[2];
                employees.add(new Employee(id, name));
            }
            System.out.println("Employees loaded from " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("No existing CSV found. Starting fresh.");
        }
    }

    // Save employees to CSV
    public void saveEmployees() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            pw.println("id,name,status");
            for (Employee e : employees) {
                pw.println(e);
            }
            System.out.println("💾 Employee list saved to " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\n--- Employee List ---");
        for (Employee e : employees) {
            System.out.println(e.getId() + " - " + e.getName());
        }
    }

public void fireEmployee(int id, String reason) {
    boolean removed = false;

    Iterator<Employee> iterator = employees.iterator();
    while (iterator.hasNext()) {
        Employee e = iterator.next();
        if (e.getId() == id) {
            System.out.println("Firing employee: " + e.getName() + " (Reason: " + reason + ")");
            iterator.remove(); // removes from the list
            removed = true;
            break;
        }
    }

    if (removed) {
        saveEmployees(); // rewrite CSV without that employee
        System.out.println("Employee ID " + id + " has been deleted from the system.");
    } else {
        System.out.println(" Employee with ID " + id + " not found.");
    }
}

    public void addEmployee(int id, String name) {
    // Check if employee already exists
    for (Employee e : employees) {
        if (e.getId() == id) {
            System.out.println("Employee with ID " + id + " already exists.");
            return;
        }
    }

    Employee newEmp = new Employee(id, name);
    employees.add(newEmp);
    saveEmployees(); // Save to CSV right away
    System.out.println("Added new employee: " + name + " (ID: " + id + ")");
}

}
