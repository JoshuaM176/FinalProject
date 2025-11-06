package coms3620.fashion.departments.finance_and_accounting;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class BudgetManager {
    private final Path dir = Paths.get("data/finance/budgets");

    public void setAllocated(String dept, double allocatedDollars) {
        try {
            Files.createDirectories(dir);
            write(dept, allocatedDollars, readSpent(dept));
            System.out.println("Allocated for " + dept + " set to $" + allocatedDollars);
        } catch (IOException e) {
            System.out.println("Error setting allocation: " + e.getMessage());
        }
    }

    public void applyExpense(String dept, double amountDollars) {
        try {
            Files.createDirectories(dir);
            double allocated = readAllocated(dept);
            double spent = readSpent(dept) + amountDollars;
            write(dept, allocated, spent);
            double remaining = allocated - spent;
            System.out.println("Applied $" + amountDollars + " to " + dept + ". Remaining: $" + remaining);
            if (remaining < 0) System.out.println("WARNING: over budget.");
        } catch (IOException e) {
            System.out.println("Error applying expense: " + e.getMessage());
        }
    }

    public void showBudget(String dept) {
        double allocated = readAllocated(dept);
        double spent = readSpent(dept);
        double remaining = allocated - spent;
        System.out.println("=== Budget " + dept + " ===");
        System.out.println("Allocated: $" + allocated);
        System.out.println("Spent    : $" + spent);
        System.out.println("Remaining: $" + remaining);
    }

    // ---------- helpers ----------
    private Path file(String dept) { return dir.resolve(dept + ".csv"); }

    private double readAllocated(String dept) {
        String[] parts = readLine(dept);
        return parts == null ? 0.0 : parse(parts[0]);
    }

    private double readSpent(String dept) {
        String[] parts = readLine(dept);
        return parts == null ? 0.0 : parse(parts[1]);
    }

    private String[] readLine(String dept) {
        Path f = file(dept);
        if (!Files.exists(f)) return null;
        try {
            List<String> lines = Files.readAllLines(f);
            String data = lines.size() > 1 && lines.get(0).startsWith("allocated")
                    ? lines.get(1) : (lines.isEmpty() ? null : lines.get(0));
            return data == null ? null : data.split(",");
        } catch (IOException e) {
            return null;
        }
    }

    private void write(String dept, double allocated, double spent) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(file(dept))) {
            bw.write("allocated,spent");
            bw.newLine();
            bw.write(allocated + "," + spent);
            bw.newLine();
        }
    }

    private static double parse(String s) {
        try { return Double.parseDouble(s.trim()); } catch (Exception e) { return 0.0; }
    }
}
