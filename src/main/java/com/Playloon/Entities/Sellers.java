package com.Playloon.Entities;

import java.util.List;

public class Sellers {

    private String storeID;
    private String sellerID;
    private String sellerName;
    private List<Product> products; // redundant



    public Sellers(String sellerID, String sellerName, String storeID)
    {
        this.sellerID = sellerID;
        this.sellerName = sellerName;
        this.storeID = storeID;
    }

    public String getStoreID() {

        return storeID;
    }

    public String getSellerID() {
        return sellerID;
    }


    public List<Product> getProducts(){      // get product by seller

        return products;
    }

    public String getSellerName() {

        return sellerName;
    }


    // setters - may remove later

    public void setStoreID(String storeID) {

        this.storeID = storeID;
    }

    public void setSellerID(String sellerID) {

        this.sellerID = sellerID;
    }

    public void setProducts(List<Product> products)   // set product by seller
    {
        this.products = products;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }



}
