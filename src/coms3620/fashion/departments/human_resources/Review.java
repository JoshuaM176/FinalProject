package coms3620.fashion.departments.human_resources;

public class Review {

    int id;
    int employeeID;
    int reviewerID;
    String comment;
    String date;

    public Review(int id, int employeeID, int reviewerID, String comment, String date){

    this.id = id;
    this.employeeID = employeeID;
    this.reviewerID = reviewerID;
    this.comment = comment;
    this.date = date;

    }
    public int getId(){
        return id;
    }
    public int getEmployeeID(){
        return employeeID;
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
