/**
* @author Alexander Tran
*/
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
        // Use ALL prototypes, not just unapproved
        List<Prototype> all = repo.findAll();
        if (all.isEmpty()) {
            System.out.println("No prototypes available.");
            return;
        }

        // show numbered list
        for (int i = 0; i < all.size(); i++) {
            Prototype p = all.get(i);
            String status = p.isApproved() ? "APPROVED" : "PENDING";
            System.out.println((i + 1) + ". " + p + " [" + status + "]");
        }

        System.out.println("Select prototype to approve/reject: ");
        int idx = InputValidation.IntegerRangeInput(1, all.size()) - 1;
        Prototype chosen = all.get(idx);

        System.out.println("1) Approve   2) Reject   0) Cancel");
        int choice = InputValidation.IntegerRangeInput(0, 2);
        if (choice == 0) {
            return;
        }

        if (choice == 1) {
            chosen.approve();
        } else {
            chosen.unapprove();
        }
        repo.save();
        System.out.println("Prototype " + chosen.getId() + " has been "
                + (choice == 1 ? "approved" : "rejected") + ".");
    }

}
