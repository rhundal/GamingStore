package com.Playloon.Entities;

//import com.Playloon.Entities.Category;

import java.util.List;
import java.util.Optional;

public class Product {


    private String productID;
    private Optional<String> itemID; //May not have this  (For Later) // 1 to Many - 1 product can be in many items
    private Optional<List<Sellers>> sellers;    // Many to Many
 //   private String productName;
    private double price;
    private String description;
    private String title;
    private String categoryId;    // do this later
    private String imageURL;


    public Product(String productID, Optional<List<Sellers>> sellers)       // for later
    {
        this.productID = productID;
        this.sellers = sellers;

    }

    public Product(String productID, double price, String description, String title, String imageURL, String categoryId, Optional<String> itemID)
    {
        this.productID = productID;
        this.price = price;
        this.description = description;
        this.title = title;
        this.imageURL = imageURL;
        this.categoryId = categoryId;
        this.itemID = itemID;
    }

    // getters

    public String getProductID() {

        return productID;
    }

    public Optional<String> getItemID()
    {
        return itemID;
    }


    public Optional<List<Sellers>> getSellers()     // return sellers for a product
    {
        return sellers;
    }


 /*   public String getProductName()
    {
        return productName;
    }
*/

    public double getPrice() {

        return price;
    }

    public String getDescription() {

        return description;
    }


    public String getTitle() {

        return title;
    }


    public String getCategoryId() {

        return categoryId;
    }


    public String getImage() {

        return imageURL;
    }


    // Setters

    public void setProductID(String productID) {

        this.productID = productID;
    }

    public void setSellers(Optional<List<Sellers>> sellers)   // set sellers for product
    {
        this.sellers = sellers;
    }

    /*
    public void setProductName(String productName) {

        this.productName = productName;
    }
*/

    public void setPrice(double price) {

        this.price = price;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setCategoryId(String categoryId) {

        this.categoryId = categoryId;
    }


    public void setImage(String imageURL) {

        this.imageURL = imageURL;

    }  // save image in database

    public void setItemID(Optional<String> itemID) {

        this.itemID = itemID;

    }
}


/* For Later */

// private List<Reviews> reviews;        // Many to 1 - Each review belongs to 1 product
//private String ImageURL;

 /*
    public void setReviews(List<Reviews> reviews){      // setting reviews for a product
        // (might have to change, add 1 review at a time

        this.reviews = reviews;

    }

    public List<Reviews> getReviews()     // return reviews for a product
    {
        return reviews;
    }

    */