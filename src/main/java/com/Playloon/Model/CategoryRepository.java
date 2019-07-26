package com.Playloon.Model;


import com.Playloon.Entities.Category;
import com.Playloon.Exceptions.InfrastructureException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Playloon.Model.ResultSetUtil.buildCategory;

public class CategoryRepository extends BaseRepository<Category> {

    private static final String LOG_ERROR_MSG = "Error during the category %s";

    // 1 save method

    // add

    @Override
    public void add(Category category)
    {
        // make connection
        // add to database
        // check constraints or triggers, do database validation

        Connection connection = openConnection();


        try {
            String sql = "INSERT INTO category(CategoryId, CategoryName) VALUES(?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, category.getcategoryID());
            pstmt.setString(2, category.getCategoryName());

            if(pstmt.executeUpdate() == 0){
                throw new InfrastructureException("The insert wasn't executed!");
            }

        } catch (SQLException e){
         //   logger.error(String.format(LOG_ERROR_MSG, "insert"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "insert"),e);
        } finally {
            closeConnection(connection);
        }


    }
    // delete

    @Override
    public void remove(Category category)
    {
        // remove from database

        Connection connection = openConnection();

        try{

            String sql = "DELETE FROM category WHERE CategoryId = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, category.getcategoryID());

            if(pstmt.executeUpdate() == 0){
                throw new InfrastructureException("The delete wasn't executed!");
            }
        } catch (SQLException e){
           // logger.error(String.format(LOG_ERROR_MSG, "delete"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "delete"),e);
        }finally {
            closeConnection(connection);
        }

    }

    // update

    @Override
    public void update(Category category)
    {
        // update category in database

        Connection connection = openConnection();

        try{
            String sql = "UPDATE category set CategoryName = ? WHERE Category_Id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,category.getCategoryName());
            //pstmt.setString(1,category.getProducts());


            if(pstmt.executeUpdate() == 0){
                throw new InfrastructureException("The Update wasn't executed!");
            }
        } catch (SQLException e){
         //  logger.error(String.format(LOG_ERROR_MSG, "update"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "update"),e);
        } finally {
            closeConnection(connection);
        }
    }

    // find by id

    @Override
    public Optional<Category> findByID(String id)
    {
        // fetch from database

        Connection connection = openConnection();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE CategoryId=?");
            statement.setString(1,id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return Optional.of(buildCategory(resultSet));
            }
        } catch(SQLException e){
          //  logger.error(String.format(LOG_ERROR_MSG, "findById"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findById"),e);
        } finally {
            closeConnection(connection);
        }

        return Optional.empty();
    }

    // find by criteria

    @Override
    public Optional<Category> findByCriteria(String field, String criteria)
    {
        Connection connection = openConnection();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE "+field+"=?");
            statement.setString(1,criteria);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return Optional.of(buildCategory(resultSet));
            }
        } catch(SQLException e){
         //   logger.error(String.format(LOG_ERROR_MSG, "findById"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findById"),e);
        } finally {
            closeConnection(connection);
        }

        return Optional.empty();
    }

    // find all

    @Override
    public List<Category> findAll()     // return list of Categories
    {
        // get from database

        List<Category> categoriesFound = new ArrayList<>();

        Connection conn = openConnection();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM category");


            while (resultSet.next()) {          // fetch only next 15 (Pagination Result)
                categoriesFound.add(buildCategory(resultSet));
            }

        } catch (SQLException e) {
          //  logger.error(String.format(LOG_ERROR_MSG, "findAll"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findAll"),e);
        } finally {
            closeConnection(conn);
        }

        return categoriesFound;

    }
}
