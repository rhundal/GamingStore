package com.Playloon.Entities;

import java.util.List;

public class Stores {

    private String storeID;
    private String storeName;
    private List<Sellers> sellers;  // 1 to Many - 1 store has many sellers


    public Stores(String storeID, String storeName)
    {
        this.storeID = storeID;
        this.storeName = storeName;
       // this.sellers = sellers;
     }

    public String getStoreID() {

        return storeID;
    }

    public String getStoreName() {

        return storeName;
    }

    public List<Sellers> getSellers()   // get sellers for store
    {
        return sellers;
    }

    // setters - may remove this later

    public void setStoreID(String storeID) {

        this.storeID = storeID;
    }

    public void setStoreName(String storeName)      // set store for a seller
    {
        this.storeName = storeName;
    }

    public void setSellers(List<Sellers> sellers)   // set sellers for store
    {
        this.sellers = sellers;
    }

}
