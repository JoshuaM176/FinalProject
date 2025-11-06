package coms3620.fashion.departments.finance_and_accounting;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.UUID;

public class ExpenseRecorder {
    private final Path ledgerFile = Paths.get("data/finance/ledger.txt");

    public void recordExpense(String dept, double amount, String vendor, String category, String description) {
        try {
            Files.createDirectories(ledgerFile.getParent());
            boolean exists = Files.exists(ledgerFile);
            try (BufferedWriter bw = Files.newBufferedWriter(ledgerFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                if (!exists) {
                    bw.write("id,dept,date,amount,vendor,category,description");
                    bw.newLine();
                }
                String id = UUID.randomUUID().toString();
                String date = LocalDate.now().toString();
                bw.write(String.join(",", id, dept, date, String.valueOf(amount), vendor, category, description));
                bw.newLine();
                System.out.println("Expense recorded for " + dept + ": $" + amount);
            }
        } catch (IOException e) {
            System.out.println("Error recording expense: " + e.getMessage());
        }
    }

    public void showLedger() {
        try {
            if (Files.exists(ledgerFile)) {
                System.out.println("=== Expense Ledger ===");
                Files.lines(ledgerFile).forEach(System.out::println);
            } else {
                System.out.println("No expenses recorded yet.");
            }
        } catch (IOException e) {
            System.out.println("Error reading ledger: " + e.getMessage());
        }
    }

    // For quick testing
    public static void main(String[] args) {
        ExpenseRecorder er = new ExpenseRecorder();
        er.recordExpense("FIN", 250.00, "Office Depot", "Supplies", "Printer ink");
        er.showLedger();
    }
}
