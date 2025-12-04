package coms3620.fashion.departments.human_resources.service;
import coms3620.fashion.departments.human_resources.Employee;
import coms3620.fashion.departments.human_resources.repository.EmployeeRepo;

import java.io.*;
import java.util.*;

public class ManageEmployees {
    private List<Employee> employees = new ArrayList<>();
    private EmployeeRepo employeeRepo = new EmployeeRepo();
    private static final String FILE_NAME = "data/human_resources/employees.csv";


    public void saveEmployees() {
        employeeRepo.saveEmployees();
    }

    public void loadEmployees() {
        employeeRepo.loadEmployees();
    }

    public void showEmployees() {
        employeeRepo.loadEmployees(); // loads into repo’s internal list

        List<Employee> list = employeeRepo.getEmployees(); // get list from repo

        if (list.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\n--- Employee List ---");
        for (Employee e : list) {
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

    public void addEmployee(int id, String name, String level, String location, String title, int salary) {
        // Check if employee already exists
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println("Employee with ID " + id + " already exists.");
                return;
            }
        }

        Employee newEmp = new Employee(id, name, level, location, title, salary);
        employees.add(newEmp);
        saveEmployees(); // Save to CSV right away
        System.out.println("Added new employee: " + name + " (ID: " + id + ")");
    }

    public void changeSalary(int id, int salary) {

        boolean change = false;

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            if (e.getId() == id) {
                e.setSalary(salary);
                System.out.println("Employee: " + e.getName() + " has been changed to salary: " + salary);
                iterator.remove(); // removes from the list
                change = true;
                break;
            }
        }
        if(change){
            saveEmployees();
        }
    }
}
