package coms3620.fashion.departments.human_resources;

public class Review {

    int reviewId;
    int revieweeId;
    int reviewerID;
    String comment;
    String date;

    public Review(int reviewId, int revieweeId, int reviewerID, String comment, String date){

    this.reviewId = reviewId;
    this.revieweeId = revieweeId;
    this.reviewerID = reviewerID;
    this.comment = comment;
    this.date = date;

    }
    public int getReviewId() {   // capital R
        return reviewId;
    }
    public int getRevieweeId() {
        return revieweeId;
    }
    public int getReviewerID(){
        return reviewerID;
    }
    public String getComment(){
        return comment;
    }
    public String getDate(){
        return date;
    }


}
