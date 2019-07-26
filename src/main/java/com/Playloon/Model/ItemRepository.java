package com.Playloon.Model;

import com.Playloon.Entities.Item;
import com.Playloon.Exceptions.InfrastructureException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Playloon.Model.ResultSetUtil.buildItem;

public class ItemRepository extends BaseRepository<Item>{

    private static final String LOG_ERROR_MSG = "Error during the category %s";

    @Override
    public void add(Item item) {
        // make connection
        // add to database
        // check constraints or triggers, do database validation

        Connection connection = openConnection();

        try {
            String sql = "INSERT INTO item(ItemId, CartId, Quantity, Price) VALUES(?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, item.getItemId());
            pstmt.setString(2, item.getCartID());
            pstmt.setInt(3, item.getQuantity());
            pstmt.setDouble(4, item.getPrice());

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
    public void remove(Item item) {
        // remove from database

        Connection connection = openConnection();

        try {

            String sql = "DELETE FROM item WHERE itemID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, item.getItemId());

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
    public void update(Item item)            // need to update this
    {
        // update category in database

        Connection connection = openConnection();

        try {
            String sql = "UPDATE item set Quantity = ? WHERE itemID = ?";  // update this

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1,item.getQuantity());


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
    public Optional<Item> findByID(String id)     // update this
    {
        // fetch from database

        Connection connection = openConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM item WHERE itemID =?");
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(buildItem(resultSet));
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
    public Optional<Item> findByCriteria(String field, String criteria) {
        Connection connection = openConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM item WHERE " + field + "=?");
            statement.setString(1, criteria);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(buildItem(resultSet));
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
    public List<Item> findAll()     // return list of Categories
    {
        // get from database

        List<Item> items = new ArrayList<>();

        Connection conn = openConnection();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM item");


            while (resultSet.next()) {          // fetch only next 15 (Pagination Result)
                items.add(buildItem(resultSet));
            }

        } catch (SQLException e) {
            // logger.error(String.format(LOG_ERROR_MSG, "findAll"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findAll"),e);
        } finally {
            closeConnection(conn);
        }

        return items;

    }
}
