package com.Playloon.Entities;

import java.util.List;

public class SellerProduct {


    private String sellerID;
    private String productID;
    private List<Product> products;


    public SellerProduct(String sellerID, String productID) // called for M2M
    {
        this.sellerID = sellerID;
        this.productID = productID;

    }

    public String getSellerID() {
        return sellerID;
    }

    public void setSellerID(String sellerID) {

        this.sellerID = sellerID;
    }

    public String getProductId() {

        return productID;
    }

    public void setProductID(String productID) {

        this.productID = productID;
    }

}
