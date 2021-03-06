package com.techelevator.model;

public class Review {

    private int reviewId;
    private int rating;
    private String reviewBody;
    private int userId;
    private String username;

    public Review() { }

    public Review(int reviewId, int rating, String reviewBody, int userId, String username) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewBody = reviewBody;
        this.userId = userId;
        this.username = username;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
