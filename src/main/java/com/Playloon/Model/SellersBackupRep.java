package com.Playloon.Model;

import com.Playloon.Entities.Sellers;
import com.Playloon.Exceptions.InfrastructureException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Playloon.Model.ResultSetUtil.buildSeller;

public class SellersBackupRep {

    /*


 public void add(Sellers seller) {
        // make connection
        // add to database
        // check constraints or triggers, do database validation

        Connection connection = openConnection();


        try {
        String sql = "INSERT INTO sellers(SellerId, FullName, StoreId) VALUES(?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, seller.getSellerID());
        pstmt.setString(2, seller.getSellerName());
        pstmt.setString(3, seller.getStoreID());

        /* get list of products */ /*

        if (pstmt.executeUpdate() == 0) {
            throw new InfrastructureException("The insert wasn't executed!");
        }

    } catch (SQLException e) {
        //    logger.error(String.format(LOG_ERROR_MSG, "insert"), e);
        throw new InfrastructureException(String.format(LOG_ERROR_MSG, "insert"),e);
    } finally {
        closeConnection(connection);
    }

}




    */
}
