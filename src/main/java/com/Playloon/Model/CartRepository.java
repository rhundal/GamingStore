package com.Playloon.Model;

import com.Playloon.Entities.Cart;
import com.Playloon.Exceptions.InfrastructureException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Playloon.Model.ResultSetUtil.buildCart;


public class CartRepository extends BaseRepository<Cart> {

    // 1 save method

    // add

    private static final String LOG_ERROR_MSG = "Error during the category %s";

    @Override
    public void add(Cart order) {
        // make connection
        // add to database
        // check constraints or triggers, do database validation

        Connection connection = openConnection();


        try {
            String sql = "INSERT INTO cart(cartID, CustomerId, DateofPurchase) VALUES(?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, order.getCartID());
            pstmt.setString(2, order.getCustomerID());
            pstmt.setDate(3, new java.sql.Date(order.getDate().getTime()));


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

    // delete

    @Override
    public void remove(Cart order) {
        // remove from database

        Connection connection = openConnection();

        try {

            String sql = "DELETE FROM cart WHERE cartID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, order.getCartID());

            if (pstmt.executeUpdate() == 0) {
                  throw new InfrastructureException("The delete wasn't executed!");
            }
        } catch (SQLException e) {
            // logger.error(String.format(LOG_ERROR_MSG, "delete"), e);
              throw new InfrastructureException(String.format(LOG_ERROR_MSG, "delete"),e);
        } finally {
            closeConnection(connection);
        }

    }
    // update

    @Override
    public void update(Cart order)            // need to update this
    {
        // update category in database

        Connection connection = openConnection();

        try {
            String sql = "UPDATE cart set CustomerId = ?, DateofPurchase = ? WHERE cartID = ?";  // update this

            PreparedStatement pstmt = connection.prepareStatement(sql);

                pstmt.setString(1,order.getCustomerID());
                pstmt.setDate(2,new java.sql.Date(order.getDate().getTime()));



            if (pstmt.executeUpdate() == 0) {
                     throw new InfrastructureException("The Update wasn't executed!");
            }
        } catch (SQLException e) {
            //    logger.error(String.format(LOG_ERROR_MSG, "update"), e);
               throw new InfrastructureException(String.format(LOG_ERROR_MSG, "update"),e);
        } finally {
            closeConnection(connection);
        }
    }

    // find by id

    @Override
    public Optional<Cart> findByID(String id)     // update this
    {
        // fetch from database

        Connection connection = openConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cart WHERE cartID =?");
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(buildCart(resultSet));
            }
        } catch (SQLException e) {
            //  logger.error(String.format(LOG_ERROR_MSG, "findById"), e);
               throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findById"),e);
        } finally {
            closeConnection(connection);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Cart> findByCriteria(String field, String criteria) {
        Connection connection = openConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cart WHERE " + field + "=?");
            statement.setString(1, criteria);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(buildCart(resultSet));
            }
        } catch (SQLException e) {
            // logger.error(String.format(LOG_ERROR_MSG, "findById"), e);
              throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findById"),e);
        } finally {
            closeConnection(connection);
        }

        return Optional.empty();
    }

    // find all

    @Override
    public List<Cart> findAll()     // return list of Categories
    {
        // get from database

        List<Cart> orders = new ArrayList<>();

        Connection conn = openConnection();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM cart");


            while (resultSet.next()) {          // fetch only next 15 (Pagination Result)
                orders.add(buildCart(resultSet));
            }

        } catch (SQLException e) {
            // logger.error(String.format(LOG_ERROR_MSG, "findAll"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findAll"),e);
        } finally {
            closeConnection(conn);
        }

        return orders;

    }
}
