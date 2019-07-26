package com.Playloon.Entities;

import java.util.Date;
import java.util.List;


public class Cart {

    private String customerID;
    private String cartID;
    private Date date;
    private List<Item> items;       //  will be adding multiple items in the cart


    public Cart(String cartID, String customerID, Date date, List<Item> items)
    {
        this.cartID = cartID;
        this.customerID = customerID;
        this.date = date;
        this.items = items;

    }

    public String getCustomerID() {

        return customerID;
    }

    public String getCartID() {

        return cartID;
    }

    public Date getDate() {

        return date;        // correct this
    }

    public List<Item> getItems() {

        return items;
    }

   /* Setters */

    public void setCustomerID(String customerID)
    {
        this.customerID = customerID;
    }


    public void setCartID(String cartID) {

        this.cartID = cartID;
    }

    public void setDate(Date date) {

        this.date = date;
    }


    public void setItems(List<Item> items) {

        this.items = items;
    }

}


