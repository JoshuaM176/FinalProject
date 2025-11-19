package coms3620.fashion.menus.productdevelopment;

import coms3620.fashion.departments.product_development.PrototypeRepository;
import coms3620.fashion.menus.Option;
import java.util.List;
import coms3620.fashion.departments.product_development.Prototype;
import coms3620.fashion.util.InputValidation;

public class ApproveRejectPrototype implements Option {

    private final PrototypeRepository repo;

    public ApproveRejectPrototype(PrototypeRepository repo) {
        this.repo = repo;
    }

    @Override 
    public String getName() {
        return "Approve / Reject Prototype";
    }

    @Override 
    public void run() {
        List<Prototype> pending = repo.findAll()
                                      .stream()
                                      .filter(p -> !p.isApproved())
                                      .toList();
        if (pending.isEmpty()) {
            System.out.println("Everything is already approved.");
            return;
        }
        // show numbered list
        for (int i = 0; i < pending.size(); i++) {
            System.out.println((i + 1) + ". " + pending.get(i));
        }
        int idx = InputValidation.IntegerRangeInput(1, pending.size()) - 1;
        Prototype chosen = pending.get(idx);

        System.out.println("1) Approve   2) Reject   0) Cancel");
        int choice = InputValidation.IntegerRangeInput(0, 2);
        if (choice == 0) return;

        if (choice == 1) chosen.approve();
        else chosen.setApproved(false);   // reject

        repo.save();
        System.out.println("Prototype " + chosen.getId() + " has been " +
                          (choice == 1 ? "approved" : "rejected") + ".");
    }
}
