package coms3620.fashion.departments.finance_and_accounting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for loading and saving Budget and Expense data.
 * Mirrors the structure of PrototypeRepository used in Product Development.
 */
public class FinanceRepository {

    private final FinanceStorage budgetStorage;
    private final FinanceStorage expenseStorage;

    public FinanceRepository() {
        this.budgetStorage = new FinanceStorage("data/finance_and_accounting/budgets.csv");
        this.expenseStorage = new FinanceStorage("data/finance_and_accounting/expenses.csv");
    }

    // ============================================================
    // BUDGET OPERATIONS
    // ============================================================

    public List<Budget> loadBudgets() {
        List<Budget> budgets = new ArrayList<>();
        try {
            List<String> lines = budgetStorage.readAll();
            for (String line : lines) {
                String[] parts = line.split(",");
                if (!parts[0].equals("sii")) continue;
                budgets.add(new Budget(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
            }
        } catch (IOException ignored) {}
        return budgets;
    }

    public void saveBudgets(List<Budget> budgets) {
        try {
            for (Budget b : budgets) {
                String row = "sii," + b.getDepartmentName() + "," + b.getYearlyBudget() + "," + b.getSpentToDate();
                budgetStorage.write(row);
            }
        } catch (IOException ignored) {}
    }

    // Expense Ops
    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        try {
            List<String> lines = expenseStorage.readAll();
            for (String line : lines) {
                String[] parts = line.split(",");
                if (!parts[0].equals("ssis")) continue;
                expenses.add(new Expense(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
            }
        } catch (IOException ignored) {}
        return expenses;
    }

    public void saveExpenses(List<Expense> expenses) {
        try {
            for (Expense e : expenses) {
                String row = "ssis," + e.getRecordType() + "," + e.getDescription() + "," + e.getAmount() + "," + e.getDate();
                expenseStorage.write(row);
            }
        } catch (IOException ignored) {}
    }
}
