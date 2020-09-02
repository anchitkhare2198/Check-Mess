package com.example.messmanagementsystem;

public class RatingType {
    private String UserRating;

    public RatingType() {
    }

    public RatingType(String userRating) {
        UserRating = userRating;
    }

    public String getUserRating() {
        return UserRating;
    }
}
