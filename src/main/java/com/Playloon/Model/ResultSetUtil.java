package com.Playloon.Model;

import com.Playloon.Entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultSetUtil {


    public static User buildUser(ResultSet resultSet) throws SQLException {

        String id = resultSet.getString("userId");
        String fName = resultSet.getString("FirstName");
        String lName = resultSet.getString("LastName");
        String email = resultSet.getString("Email");
        String password = resultSet.getString("Password");
        UserTypes type  = UserTypes.valueOf(resultSet.getString("userType"));   // check for enum
       // String type  = resultSet.getString("userType");   // check for enum

        return new User(id, fName, lName, email, password, type);
    }

    public static Category buildCategory(ResultSet resultSet) throws SQLException {

        List<String> productsId = new ArrayList<String>();

        String id = resultSet.getString("CategoryId");
        String categoryName = resultSet.getString("CategoryName");

        /*
        while (resultSet.next())
        {
            productsId.add(resultSet.getString("Product_Id"));
        }
        */

        return new Category(id, categoryName);

    }

    public static Cart buildCart(ResultSet resultSet) throws SQLException {


        List<Item> itemsList = new ArrayList<Item>();
        String itemId;

        String idCart = resultSet.getString("CartId");
        String idCustomer = resultSet.getString("CustomerId");
        Date date = resultSet.getDate("DateofPurchase");

        while (resultSet.next())
        {
            itemId = resultSet.getString("Item_Id");

          //  itemsList.add(resultSet.getObject("Item_Id"));  // need to fix this
        }

        return new Cart(idCustomer, idCart, date, itemsList);

    }

    public static Item buildItem(ResultSet resultSet) throws SQLException {

        List<Product> products = new ArrayList<Product>();
        String idItem = resultSet.getString("Item_Id");
        String idCart = resultSet.getString("Cart_Id");
        int quantity = resultSet.getInt("Quantity");
        double price = resultSet.getDouble("Price");

        return new Item(idItem, idCart, quantity, price, products);

    }

    public static Product buildProduct(ResultSet resultSet) throws SQLException {

        String idProduct = resultSet.getString("ProductId");
       // List<Sellers> sellers = new ArrayList<Sellers>();
        double price = resultSet.getDouble("Price");
        String description = resultSet.getString("Description");
        String title = resultSet.getString("Title");
        String imageURL = resultSet.getString("ImageURL");
        String categoryId = resultSet.getString("categoryId");
        String itemId = null;

        return new Product(idProduct, price, description, title, imageURL, categoryId, null);

    }

    public static Sellers buildSeller(ResultSet resultSet) throws SQLException {

        String idSeller = resultSet.getString("SellerId");
        String fullName = resultSet.getString("FullName");
        String idStore = resultSet.getString("StoreId");

        return new Sellers(idSeller, fullName, idStore);

    }

    public static Stores buildStore(ResultSet resultSet) throws SQLException {

        String idStore = resultSet.getString("StoreId");
        String storeName = resultSet.getString("StoreName");

        return new Stores(idStore, storeName);

    }

    public static SellerProduct buildSellerProduct(ResultSet resultSet) throws SQLException {

        String idSeller = resultSet.getString("SellerId");
        String idProduct = resultSet.getString("ProductId");

        return new SellerProduct(idSeller, idProduct);

    }

}
