package coms3620.fashion.departments.human_resources;
import java.util.Scanner;

public class HRMain {
    public static void runHR() {
        StoreManager sm = new StoreManager();
        sm.loadEmployees();
        Scanner sc = new Scanner(System.in);

        while (true) {
    System.out.println("\n===== HR MENU =====");
    System.out.println("1. View Employees");
    System.out.println("2. Add Employee");
    System.out.println("3. Fire Employee");
    System.out.println("4. Save & Exit");
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
            sm.addEmployee(id, name);
        }
        case 3 -> {
            System.out.print("Enter employee ID to fire: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.print("Enter reason for termination: ");
            String reason = sc.nextLine();
            sm.fireEmployee(id, reason);
        }
        case 4 -> {
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
