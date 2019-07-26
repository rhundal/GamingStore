package com.Playloon.Model;

import com.Playloon.Entities.Product;
import com.Playloon.Exceptions.InfrastructureException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Playloon.Model.ResultSetUtil.buildProduct;

public class ProductRepository extends BaseRepository<Product> {


    private static final String LOG_ERROR_MSG = "Error during the category %s";

    @Override
    public void add(Product product)
    {
        // make connection
        // add to database
        // check constraints or triggers, do database validation


        Connection connection = openConnection();

        try {

            String sql = "INSERT INTO product(ProductId, Price, Description, Title, ImageURL, CategoryId, ItemId) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, product.getProductID());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setString(3, product.getDescription());
            pstmt.setString(4, product.getTitle());
            pstmt.setString(5, product.getImage());
            pstmt.setString(6, product.getCategoryId());
            pstmt.setString(7, null);


            if(pstmt.executeUpdate() == 0){
                throw new InfrastructureException("Product insert wasn't executed! - call from Product Repository");
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
    public void remove(Product product)
    {
        // remove from database

        Connection connection = openConnection();

        try{

            String sql = "DELETE FROM product WHERE ProductId = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, product.getProductID());

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
    public void update(Product product)
    {
        // update category in database

        Connection connection = openConnection();

        try{
            String sql = "UPDATE products set PricePerItem = ?, Description = ?, ProductName = ?, ImageURL = ?, CategoryName = ? WHERE ProductId = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setDouble(1, product.getPrice());
            pstmt.setString(2, product.getDescription());
            pstmt.setString(3, product.getTitle());
        //   pstmt.setString(4, product.getImageURL());
         //   pstmt.setString(5, product.getCategory());


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
    public Optional<Product> findByID(String id)
    {
        // fetch from database

        Connection connection = openConnection();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE ProductId = ?");
            statement.setString(1,id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return Optional.of(buildProduct(resultSet));
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
    public Optional<Product> findByCriteria(String field, String criteria)
    {
        Connection connection = openConnection();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE "+field+"=?");
            statement.setString(1,criteria);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return Optional.of(buildProduct(resultSet));
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
    public List<Product> findAll()     // return list of Categories
    {
        // get from database

        List<Product> products = new ArrayList<>();

        Connection conn = openConnection();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM product");


            while (resultSet.next()) {          // fetch only next 15 (Pagination Result)
                products.add(buildProduct(resultSet));
            }

        } catch (SQLException e) {
            //  logger.error(String.format(LOG_ERROR_MSG, "findAll"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findAll"),e);
        } finally {
            closeConnection(conn);
        }

        return products;

    }

    public List<Product> SortProducts(List<Product> products)       // return sorted products (database will sort them)
    {
        List<Product> sorted;       // get sorted products from database

        return products;  // change this to sorted
    }
}
