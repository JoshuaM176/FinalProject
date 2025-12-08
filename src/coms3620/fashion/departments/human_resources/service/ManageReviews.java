package coms3620.fashion.departments.human_resources.service;

import coms3620.fashion.departments.human_resources.Employee;
import coms3620.fashion.departments.human_resources.Review;
import coms3620.fashion.departments.human_resources.repository.EmployeeRepo;
import coms3620.fashion.departments.human_resources.repository.ReviewRepo;
import coms3620.fashion.departments.human_resources.service.ManageEmployees;


import java.util.ArrayList;
import java.util.List;

public class ManageReviews {

    private ReviewRepo reviewRepo = new ReviewRepo();

    public void loadReviews() {
        reviewRepo.loadReviews();
    }

    public List<Review> getReviews() {
        return reviewRepo.getAllReviews();
    }


    public List<Review> getReviewsByEmployeeId(int id) {
        List<Review> results = new ArrayList<>();

        for (Review r : reviewRepo.getAllReviews()) {
            if (r.getRevieweeId() == id) {
                results.add(r);
            }
        }
        return results;
    }

    public void printReviewsByEmployeeId(int id) {
        //System.out.println("DEBUG total reviews loaded: " + reviewRepo.getAllReviews().size());
        List<Review> results = getReviewsByEmployeeId(id);

        if (results.isEmpty()) {
            System.out.println("No reviews found for employee ID: " + id);
            return;
        }

        for (Review review : results) {
            System.out.println(
                    review.getReviewId() + " - " +
                            review.getRevieweeId() + " - " +
                            review.getReviewerID() + " - " +
                            review.getComment() + " - " +
                            review.getDate()
            );
        }
    }



    //    public void getReviewByEmployeeID(int id) {
//
//        ManageEmployees manageEmployees = new ManageEmployees();
//        manageEmployees.loadEmployees();
//
//        Employee employee = manageEmployees.getEmployeeForReview(id);
//
//
//        for (Review review : review) {
//            if(employee.getId() == review.getEmployeeID()) {
//                System.out.println(review.getId() + " - " + review.getEmployeeID() + " - " + review.getReviewerID() + " - " + review.getComment() + " - " + review.getDate());
//            }
//        }
//        System.out.println("No review found");
//    }



}
