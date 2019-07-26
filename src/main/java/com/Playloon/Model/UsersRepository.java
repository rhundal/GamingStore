package com.Playloon.Model;

import com.Playloon.Entities.User;
import com.Playloon.Exceptions.InfrastructureException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Playloon.Model.ResultSetUtil.buildUser;

public class UsersRepository extends BaseRepository<User> {

    private static final String LOG_ERROR_MSG = "Error during the user %s";

    // add

    @Override
    public void add(User newUser)                // IMPLEMENT THIS 2
    {
        // make connection
        // add to database
        // check constraints or triggers, do database validation
        // check type of user - admin or customer and save

        Connection connection = openConnection();

        try {

            //Class.forName("com.mysql.jdbc.Driver");

                // save as admin or customer


                String sql = "INSERT INTO users(userId,FirstName, LastName, Email, Password, userType) VALUES(?,?,?,?,?,?)";

                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, newUser.getUserID());
                pstmt.setString(2, newUser.getFirstName());
                pstmt.setString(3, newUser.getLastName());
                pstmt.setString(4, newUser.getEmail());
                pstmt.setString(5, newUser.getPassword());
                pstmt.setString(6, newUser.getUserType().name());      // double check
                                                                                // check order of parameters
                if(pstmt.executeUpdate() == 0)
                {
                    // throw error

                    System.out.println("No records inserted");
                }

        }
        catch (Exception e)
        {
           e.printStackTrace();

        }finally {
            closeConnection(connection);
        }

    }

    // delete

    @Override
    public void remove(User newUser)
    {
        // remove from database

        //System.out.println("Testing");
      //  System.out.println("--> " + newUser.getUserID());

        Connection connection = openConnection();

        try{

            String sql = "DELETE FROM users WHERE userId = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, newUser.getUserID());

            if(pstmt.executeUpdate() == 0){
                System.out.println("No user deleted");
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
    public void update(User newUser)
    {
        // update user in database

        Connection connection = openConnection();
        try{
            String sql = "UPDATE users SET FirstName = ?, LastName = ?, Email = ?, Password = ?,userType = ? WHERE userId = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, newUser.getFirstName());
            pstmt.setString(2, newUser.getLastName());
            pstmt.setString(3, newUser.getEmail());
            pstmt.setString(4, newUser.getPassword());
            pstmt.setString(5, newUser.getUserType().name());        // set Enum sype

            System.out.println(newUser.getLastName());

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
    public Optional<User> findByID(String id)        // return 1 user
    {
        Connection connection = openConnection();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE userId=?");
            statement.setString(1,id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return Optional.of(buildUser(resultSet));
            }
        } catch(SQLException e){
            //logger.error(String.format(LOG_ERROR_MSG, "findById"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findById"),e);
        } finally {
            closeConnection(connection);
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> findByCriteria(String field, String criteria) {

        Connection connection = openConnection();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE "+field+"=?");
            statement.setString(1,criteria);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return Optional.of(buildUser(resultSet));
            }
        } catch(SQLException e){
           // logger.error(String.format(LOG_ERROR_MSG, "findById"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findById"),e);
        } finally {
            closeConnection(connection);
        }

        return Optional.empty();
    }

    // find all

    @Override
    public List<User> findAll()     // return list of users // IMPLEMENT THIS 1
    {
        // get from database

        // check for equal

        List<User> users = new ArrayList<User>();

        Connection conn = openConnection();

        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE userId=?");
            ResultSet resultSet = statement
                    .executeQuery();

            while (resultSet.next()) {
                users.add(buildUser(resultSet));
            }

        } catch (SQLException e) {
         //  logger.error(String.format(LOG_ERROR_MSG, "findAll"), e);
            throw new InfrastructureException(String.format(LOG_ERROR_MSG, "findAll"),e);
        } finally {
            closeConnection(conn);
        }
        return users;

    }


}
