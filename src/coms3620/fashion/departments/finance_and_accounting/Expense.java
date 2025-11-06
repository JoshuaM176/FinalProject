package coms3620.fashion.departments.finance_and_accounting;

import java.util.UUID;

public class Expense {
    public final UUID id;
    public final String dept;
    public final String dateIso;     // e.g., 2025-11-05
    public final int amountCents;    // store in cents to avoid FP issues
    public final String vendor;
    public final String category;
    public final String description;
    public boolean overBudget;

    public Expense(String dept, String dateIso, int amountCents,
                   String vendor, String category, String description) {
        this.id = UUID.randomUUID();
        this.dept = dept;
        this.dateIso = dateIso;
        this.amountCents = amountCents;
        this.vendor = vendor;
        this.category = category;
        this.description = description;
        this.overBudget = false;
    }

    public String toCsv() {
        // entryId,timestamp(deprecated),dept,date,amountCents,vendor,category,description,overBudget
        return id + "," + dept + "," + dateIso + "," + amountCents + "," +
               escape(vendor) + "," + escape(category) + "," + escape(description) + "," + overBudget;
    }

    private static String escape(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("\"")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }
}
