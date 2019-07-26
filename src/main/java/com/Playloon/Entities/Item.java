package com.Playloon.Entities;

import java.util.List;

public class Item {

    private String itemId;
    private String cartID;
    private int quantity;
    private double price;
    private List<Product> products;


    public Item(String itemId, String cartID, int quantity, double price, List<Product> products)
    {
        this.itemId = itemId;
        this.cartID = cartID;
        this.quantity = quantity;
        this.price = price;
        this.products = products;

    }

    public String getItemId() {

        return itemId;
    }

    public String getCartID() {

        return cartID;
    }

    public int getQuantity() {

        return quantity;
    }

    public double getPrice() {

        return price;
    }


    public List<Product> getProducts(){

        return products;
    }


    // setters

    public void setItemId(String itemId) {

        this.itemId = itemId;
    }

    public void setCartID(String cartID) {

        this.cartID = cartID;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }



}
