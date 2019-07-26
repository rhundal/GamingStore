package com.Playloon.Services;

import com.Playloon.Entities.User;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Exceptions.ValidationException;
import com.Playloon.Model.Repository;
import com.Playloon.Model.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserService implements Service<User> {

    // check business rules
    // call respective repository functions

    private Repository<User> userRep;
    private AuthenticationService authenticationService;
    private Pattern pattern;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    List<User> myUsers = new ArrayList<User>();
    String password, email;

    public UserService(){

        userRep = new UsersRepository();
        authenticationService = new AuthenticationService();
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public UserService(Repository<User> userRepository, AuthenticationService authenticationService)
    {
        this.userRep = userRepository;
        this.authenticationService = authenticationService;
    }

    private void validate(User user)
    {
        /* validate user -

        1. check if user already exists or not - no duplicates
        2. if duplicate - > throw error
        3. check business rules - age, types

        */

        if(isEmailInvalid(user.getEmail())){
            throw new ValidationException("The email is invalid!");
        }
        if(isDuplicatedEmail(user)){
            throw new ValidationException("There is another user with the same email!");
        }


        /*
        List<User> myUsersList = new ArrayList<User>();

        myUsersList = findAll(user);      // calling repository

        if(user != null)
        {
            if(myUsersList.size() > 1)
            {
                // throw error

                System.out.println("User has duplicates");
                return false;

            }

            if(user.getAge() < 18)      // check business rule
            {
                // throw error
                System.out.println("User is under age");
                return false;

            }

        }

        return true;
        */

    }

    public boolean isEmailInvalid(final String email){

        return !pattern.matcher(email).matches();

    }

    private boolean isDuplicatedEmail(User user){       // check this

        return userRep.findByCriteria("email", user.getEmail())
                .filter(u -> !u.getUserID().equals(user.getUserID()))
                .isPresent();
    }

    @Override
    public void add(User user)
    {
        validate(user);
        user.setPassword(authenticationService.generateSecurePassword(user.getPassword()));
        userRep.add(user);

    }

    @Override
    public void update(User users)
    {

        User userDB = findByID(users.getUserID());
        validate(users);
        users.setPassword(userDB.getPassword());
        userRep.update(users);

    }

    // delete

    @Override
    public void remove(String id)
    {
        userRep.remove(findByID(id));
    }

    // find by id

    @Override
    public User findByID(String id)
    {
        return userRep.findByID(id).orElseThrow(() ->
              new EntityNotFoundException("User with id " + id + " was not found!"));

    }

    // find all

    @Override
    public List<User> findAll()
    {

        return userRep.findAll();     // calling repository

    }

    public User findByEmail(String email){

        return userRep.findByCriteria("Email", email)
                .orElseThrow(() -> new EntityNotFoundException("The user doesn't exist"));


    }

    @Override
    public Optional<User> findByCriteria(String field, String criteria){


        return userRep.findByCriteria(field, criteria);
    }


}
