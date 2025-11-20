package coms3620.fashion.departments.finance_and_accounting;

import java.util.ArrayList;
import java.util.List;

/**
 * Main logic class for Finance & Accounting.
 * Handles budgets, expenses, and simple fund transfers.
 */
public class BudgetManager {

    private final FinanceRepository repo;
    private final List<Budget> budgets;
    private final List<Expense> expenses;

    public BudgetManager() {
        this.repo = new FinanceRepository();
        this.budgets = repo.loadBudgets();
        this.expenses = repo.loadExpenses();
    }

    // --------- Budget helpers ---------

    public List<Budget> getBudgets() {
        return new ArrayList<>(budgets);
    }

    public Budget getOrCreateBudget(String deptName) {
        for (Budget b : budgets) {
            if (b.getDepartmentName().equalsIgnoreCase(deptName)) {
                return b;
            }
        }
        Budget b = new Budget(deptName, 0, 0);
        budgets.add(b);
        repo.saveBudgets(budgets);
        return b;
    }

    public void setBudgetLimit(String deptName, int newLimit) {
        Budget b = getOrCreateBudget(deptName);
        b.setYearlyBudget(newLimit);
        repo.saveBudgets(budgets);
    }

    public int getRemaining(String deptName) {
        Budget b = getOrCreateBudget(deptName);
        return b.getRemainingBudget();
    }

    // --------- Expense helpers ---------

    public void recordExpense(String deptName, String description, int amount, String date) {
        if (amount <= 0) return;
        Budget b = getOrCreateBudget(deptName);
        b.recordExpense(amount);
        expenses.add(new Expense(deptName, description, amount, date));
        repo.saveBudgets(budgets);
        repo.saveExpenses(expenses);
    }

    // --------- Transfer funds ---------

    /**
     * Transfers funds between two departments by adjusting their limits.
     *
     * @return true if transfer succeeded, false if not enough remaining in source.
     */
    public boolean transferFunds(String fromDept, String toDept, int amount) {
        if (amount <= 0 || fromDept.equalsIgnoreCase(toDept)) return false;

        Budget from = getOrCreateBudget(fromDept);
        Budget to = getOrCreateBudget(toDept);

        if (from.getRemainingBudget() < amount) {
            return false;
        }

        from.setYearlyBudget(from.getYearlyBudget() - amount);
        to.setYearlyBudget(to.getYearlyBudget() + amount);
        repo.saveBudgets(budgets);
        return true;
    }
}
