package com.Playloon.Entities;

import java.util.List;


public class User /* implements UsersFunctions */ {      // Abstract Class

    private String userID;
    public UserTypes uType;  // Enum
    private String FirstName;
    private String LastName;
    private String email;
    private String password;
    private String userType;
    private List<Cart> carts;       // 1 customer has many carts  (1 to M)


    public User(String userID, String FirstName, String LastName, String email, String password, UserTypes uType)
    {
        this.userID = userID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.email = email;
        this.password = password;
        this.uType = uType;

    }

    // abstract methods

    public String getUserID() {       // remove this later

        return userID;
    }

    public UserTypes getUserType()
    {
        return uType;
    }


    public String getFirstName() {      // get and set first name

        return FirstName;
    }

    public String getLastName() {       // get and set last name

        return LastName;
    }

    public String getEmail() {            // get and set email

        return email;
    }

    public String getPassword() {         // get and set password

        return password;
    }

    public String getUsrType()
    {
        return userType;
    }


    public List<Cart> getCarts()      // get list of customer orders
    {
        return carts;
    }



// Setters - may remove later

    public void setuType(UserTypes uType) {

        this.uType = uType;
    }

    public void setFirstName(String firstName) {

        FirstName = firstName;
    }


    public void setLastName(String lastName) {

        LastName = lastName;
    }


    public void setEmail(String email) {

        this.email = email;
    }


    public void setPassword(String password) {

        this.password = password;
    }

    public void setType(String userType)        // you cannot set Type
    {
        this.userType = userType;

    }

    public void setCarts(List<Cart> carts) {

        this.carts = carts;
    }


} // End of class


/* Functions for Testing */
 /*

     public String getType(String userResponse)         // get and set user type
    {
        String valToReturn = "NOT FOUND";

        for(UserTypes vct : UserTypes.values())
        {
            if(vct.toString().equals(userResponse))
            {
                valToReturn = vct.name();

            }

        }

        return valToReturn;
    }

    public UserTypes getMyTypes(UserTypes myTypes) {            // returns all types

        return myTypes;
    }

    public String getType(UserTypes usertype)         // get and set user type
    {
        String valueToReturn = "";

        for(UserTypes usr : UserTypes.values())
        {
            if(usr == usertype)
            {
                userType = usr.name();
            }
        }
        return userType;
    }
*/
