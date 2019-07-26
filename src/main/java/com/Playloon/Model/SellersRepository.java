package com.Playloon.Model;

import com.Playloon.Entities.Sellers;
import com.Playloon.Exceptions.InfrastructureException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Playloon.Model.ResultSetUtil.buildSeller;
import static javax.swing.JFormattedTextField.COMMIT;

public class SellersRepository extends BaseRepository<Sellers> {

    private static final String LOG_ERROR_MSG = "Error during the category %s";

    @Override
    public void add(Sellers seller) {
        // make connection
        // add to database
        // check constraints or triggers, do database validation

        Connection connection = openConnection();

        /* Use Transaction to make 2 commits */

        try {

            String sql = "INSERT INTO sellers(SellerId, FullName, StoreId) VALUES(?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, seller.getSellerID());
            pstmt.setString(2, seller.getSellerName());
            pstmt.setString(3, seller.getStoreID());

            /* get list of products */

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
    public void remove(Sellers seller) {
        // remove from database

        Connection connection = openConnection();

        try {

            String sql = "DELETE FROM sellers WHERE SellerId = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, seller.getSellerID());

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
    public void update(Sellers seller)            // need to update this
    {
        // update category in database

        Connection connection = openConnection();

        try {
            String sql = "UPDATE sellers set StoreId = ? FullName = ? WHERE SellerId = ?";  // update this

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,seller.getSellerID());
            pstmt.setString(2, seller.getStoreID());
            //  pstmt.setString(3, seller.getName());

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
    public Optional<Sellers> findByID(String id)     // update this
    {
        // fetch from database

        Connection connection = openConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM sellers WHERE SellerId =?");
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(buildSeller(resultSet));
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
    public Optional<Sellers> findByCriteria(String field, String criteria) {
        Connection connection = openConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM sellers WHERE " + field + "=?");
            statement.setString(1, criteria);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(buildSeller(resultSet));
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
    public List<Sellers> findAll()     // return list of Categories
    {
        // get from database

        List<Sellers> sellers = new ArrayList<>();

        Connection conn = openConnection();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM sellers");


            while (resultSet.next()) {          // fetch only next 15 (Pagination Result)
                sellers.add(buildSeller(resultSet));
            }

        } catch (SQLException e) {
            // logger.error(String.format(LOG_ERROR_MSG, "findAll"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findAll"),e);
        } finally {
            closeConnection(conn);
        }

        return sellers;

    }
}
