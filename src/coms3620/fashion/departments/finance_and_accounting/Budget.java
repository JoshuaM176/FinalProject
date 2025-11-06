package coms3620.fashion.departments.finance_and_accounting;

public class Budget {
    public int allocatedCents;
    public int spentCents;

    public Budget(int allocatedCents, int spentCents) {
        this.allocatedCents = allocatedCents;
        this.spentCents = spentCents;
    }

    public int remainingCents() {
        return allocatedCents - spentCents;
    }

    public String toCsv() {
        // allocatedCents,spentCents,remainingCents
        return allocatedCents + "," + spentCents + "," + remainingCents();
    }

    public static String header() {
        return "allocatedCents,spentCents,remainingCents";
    }
}
