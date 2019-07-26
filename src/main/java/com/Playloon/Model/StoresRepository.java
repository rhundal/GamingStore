package com.Playloon.Model;

import com.Playloon.Entities.Stores;
import com.Playloon.Exceptions.InfrastructureException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Playloon.Model.ResultSetUtil.buildStore;

public class StoresRepository extends BaseRepository<Stores> {

    private static final String LOG_ERROR_MSG = "Error during the category %s";

    @Override
    public void add(Stores store) {
        // make connection
        // add to database
        // check constraints or triggers, do database validation

        Connection connection = openConnection();

        try {
            String sql = "INSERT INTO stores(StoreId, StoreName) VALUES(?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, store.getStoreID());
            pstmt.setString(2, store.getStoreName());

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
    public void remove(Stores store) {
        // remove from database

        Connection connection = openConnection();

        try {

            String sql = "DELETE FROM stores WHERE StoreId = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, store.getStoreID());

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
    public void update(Stores store)            // need to update this
    {
        // update category in database

        Connection connection = openConnection();

        try {
            String sql = "UPDATE stores set StoreName = ? WHERE StoreId = ?";  // update this

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, store.getStoreName());

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
    public Optional<Stores> findByID(String id)     // update this
    {
        // fetch from database

        Connection connection = openConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM stores WHERE StoreId =?");
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(buildStore(resultSet));
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
    public Optional<Stores> findByCriteria(String field, String criteria) {
        Connection connection = openConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM stores WHERE " + field + "=?");
            statement.setString(1, criteria);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(buildStore(resultSet));
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
    public List<Stores> findAll()     // return list of Categories
    {
        // get from database

        List<Stores> stores = new ArrayList<>();

        Connection conn = openConnection();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM stores");


            while (resultSet.next()) {          // fetch only next 15 (Pagination Result)
                stores.add(buildStore(resultSet));
            }

        } catch (SQLException e) {
            // logger.error(String.format(LOG_ERROR_MSG, "findAll"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findAll"),e);
        } finally {
            closeConnection(conn);
        }

        return stores;

    }
}
