package coms3620.fashion.departments.human_resources;
import coms3620.fashion.departments.human_resources.service.ManageEmployees;
import coms3620.fashion.departments.human_resources.repository.EmployeeRepo;

import java.util.Scanner;

public class HRMain {
    public static void runHR() {
        ManageEmployees sm = new ManageEmployees();
        sm.loadEmployees();
        Scanner sc = new Scanner(System.in);

        while (true) {
    System.out.println("\n===== HR MENU =====");
    System.out.println("1. View Employees");
    System.out.println("2. Add Employee");
    System.out.println("3. Fire Employee");
    System.out.println("4. Make a change to existing employee");
    System.out.println("5. Save & Exit");
    System.out.print("Choose option: ");
    int choice = sc.nextInt();
    sc.nextLine(); // clear newline

    switch (choice) {
        case 1 -> sm.showEmployees();
        case 2 -> {
            System.out.print("Enter new employee ID: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.print("Enter new employee name: ");
            String name = sc.nextLine();
            System.out.print("Enter new employee level: ");
            String level = sc.nextLine();
            System.out.print("Enter new employee location: ");
            String location = sc.nextLine();
            System.out.print("Enter new employee title: ");
            String title = sc.nextLine();
            System.out.print("Enter new employee salary: ");
            int salary = sc.nextInt();

            sm.addEmployee(id, name, level, location, title, salary);
        }
        case 3 -> {
            System.out.print("Enter employee ID to fire: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.print("Enter reason for termination: ");
            String reason = sc.nextLine();
            sm.fireEmployee(id, reason);
        }
        case 4 -> {
            System.out.println("Enter employee ID to make a change to existing employee: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.println("What would like to change for the employee: ");
            System.out.println("Role Level");
            System.out.println("Salary");
            System.out.println("Location");
            String changed = sc.nextLine();

            switch(changed) {
                case "Role Level":


                case  "Salary":
                    System.out.print("Enter the employee's new salary: ");
                    int salary = sc.nextInt(); sc.nextLine();
                    sm.changeSalary(id, salary);
                    return;

                case "Location":


            }


        }
        case 5 -> {
            sm.saveEmployees();
            System.out.println("Exiting HR module...");
            return;
        }
        default -> System.out.println("Invalid choice. Try again.");
    }
}

    }

    public static void main(String[] args) {
        runHR();
    }
}
