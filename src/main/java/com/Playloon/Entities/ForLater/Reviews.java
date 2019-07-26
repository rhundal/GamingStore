package com.Playloon.Entities.ForLater;

import com.Playloon.Entities.Product;

public class Reviews {

    private double date;  // not sure about this
    private String userName;
    private String reviews;
    private int product_ID;
    private int rating;
    private int reviewID;
    private Product product;        // Many to 1 - 1 or more reviews belongs to 1 product


    // methods

    public Product getProduct()    // get product of a review
    {
        return product;
    }

    public void setProduct(Product product) // set product of a review (probably not going to use this)
    {
        this.product = product;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }


    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void deleteReviews()
    {

    }
}
