package coms3620.fashion.departments.human_resources.repository;

import coms3620.fashion.departments.human_resources.Employee;
import coms3620.fashion.departments.human_resources.Review;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepo {

    private static final String FILE_NAME = "data/human_resources/review.csv";
    private List<Review> review = new ArrayList<>();


    public void loadReviews()
    {
        review.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = br.readLine(); // skip header
            if (line == null) return;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int reviewId = Integer.parseInt(data[0]);
                int revieweeID = Integer.parseInt(data[1]);
                int reviewerID = Integer.parseInt(data[2]);
                String comment = data[3].trim();
                String date = data[4].trim();


                review.add(new Review(reviewId, revieweeID, reviewerID, comment, date));
            }

            System.out.println("Reviews loaded from " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("No existing CSV found.");
        }
    }

}
