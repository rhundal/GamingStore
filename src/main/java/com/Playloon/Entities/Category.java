package com.Playloon.Entities;

import java.util.List;

public class Category {

    private String categoryID;
    private String categoryName;
    private List<Product> products;


    public Category(String categoryID, String categoryName){      // using this for Resultset

        this.categoryID = categoryID;
        this.categoryName = categoryName;
      //  this.products = products;
    }


    // getters

    public String getcategoryID() {

        return categoryID;
    }

    public String getCategoryName() {

        return categoryName;
    }


    public List<Product> productID()
    {
        return products;
    }


    // Setters

    public void setCategoryID(String categoryID)
    {
        this.categoryID = categoryID;
    }


    public void setCategoryName(String categoryName) {

        this.categoryName = categoryName;
    }

    public void setProductID(List<Product> productID)
    {
        this.products = products;
    }


}
