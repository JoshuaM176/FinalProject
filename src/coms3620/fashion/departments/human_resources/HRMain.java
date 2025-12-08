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
    System.out.println("2. Find Employee by Id");
    System.out.println("3. Add Employee");
    System.out.println("4. Fire Employee");
    System.out.println("5. Make a change to existing employee");
    System.out.println("6. Save & Exit");
    System.out.print("Choose option: ");
    int choice = sc.nextInt();
    sc.nextLine(); // clear newline

    switch (choice) {
        case 1 -> sm.showEmployees();
        case 2 -> {
            System.out.print("Enter Employee Id: ");
            sm.getEmployee(sc.nextInt());
        }
        case 3 -> {
            System.out.print("Enter new employee ID: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.print("Enter new employee name: ");
            String name = sc.nextLine();
            System.out.println("Enter new employee level:");
            System.out.println("1. Junior");
            System.out.println("2. Senior");
            System.out.println("3. Manager");

            int chosenLevel = sc.nextInt();
            sc.nextLine(); // clear buffer

            Employee.RoleLevel newLevel;

            switch (chosenLevel) {
                case 1: newLevel = Employee.RoleLevel.JUNIOR; break;
                case 2: newLevel = Employee.RoleLevel.SENIOR; break;
                case 3: newLevel = Employee.RoleLevel.MANAGER; break;
                default:
                    System.out.println("Invalid level.");
                    return;
            }

            System.out.print("Enter new employee location: ");
            String location = sc.nextLine();
            System.out.print("Enter new employee title: ");
            String title = sc.nextLine();
            System.out.print("Enter new employee salary: ");
            int salary = sc.nextInt();

            sm.addEmployee(id, name, newLevel, location, title, salary);
        }
        case 4 -> {
            System.out.print("Enter employee ID to fire: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.print("Enter reason for termination: ");
            String reason = sc.nextLine();
            sm.fireEmployee(id, reason);
        }
        case 5 -> {
            System.out.println("Enter employee ID to make a change to existing employee: ");
            int id = sc.nextInt(); sc.nextLine();

            if (!sm.employeeExists(id)) {
                System.out.println("Error: Employee with that ID does not exist.");
            } else {
                System.out.println("What would like to change for the employee: ");
                System.out.println("1. Role Level");
                System.out.println("2. Salary");
                System.out.println("3. Location");
                int changed = sc.nextInt();
                sc.nextLine();

                switch (changed) {
                    case 1:
                        System.out.println("Enter the employee's new role level:");
                        System.out.println("1. Junior");
                        System.out.println("2. Senior");
                        System.out.println("3. Manager");

                        int chosenLevel = sc.nextInt();
                        sc.nextLine(); // clear buffer

                        Employee.RoleLevel newLevel;

                        switch (chosenLevel) {
                            case 1 -> newLevel = Employee.RoleLevel.JUNIOR;
                            case 2 -> newLevel = Employee.RoleLevel.SENIOR;
                            case 3 -> newLevel = Employee.RoleLevel.MANAGER;
                            default -> {
                                System.out.println("Invalid choice — defaulting to JUNIOR.");
                                newLevel = Employee.RoleLevel.JUNIOR;
                            }
                        }
                        sm.changeRoleLevel(id, newLevel);
                        break;

                    case 2:
                        System.out.print("Enter the employee's new salary: ");
                        int salary = sc.nextInt();
                        sc.nextLine();

                        sm.changeSalary(id, salary);
                        break;


                    case 3:
                        System.out.println("Enter the employee's new location: ");
                        String location = sc.nextLine();

                        sm.changeLocation(id, location);
                        break;



                }
            }


        }
        case 6 -> {
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
