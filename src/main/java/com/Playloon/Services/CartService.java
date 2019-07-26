package com.Playloon.Services;

import com.Playloon.Entities.Cart;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Exceptions.ValidationException;
import com.Playloon.Model.CartRepository;
import com.Playloon.Model.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CartService implements Service<Cart> {


    private Repository<Cart> cartRepository;

    private List<Cart> orders = new ArrayList<Cart>();

    public CartService()
    {
        cartRepository = new CartRepository();
    }

    public CartService(Repository<Cart> cartRepository)
    {
        this.cartRepository = new CartRepository();              // ask alex about this
    }


    @Override
    public void add(Cart order)
    {
        validate(order);     // check business rules and duplicates
        cartRepository.add(order); // call CategoryRepository
    }

    @Override
    public void remove(String id)
    {
        cartRepository.remove(cartRepository
                .findByID(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Cart with id " + id + " was not found!"))
        );

    }

    @Override
    public void update(Cart order)
    {
        cartRepository
                .findByID(order.getCartID())
                .orElseThrow(
                        () -> new EntityNotFoundException("Car with id " + order.getCartID() + " was not found!"));

        validate(order);
        cartRepository.update(order);
    }

    @Override
    public Cart findByID(String id)
    {

        return cartRepository.findByID(id).orElseThrow(() -> new EntityNotFoundException("Cart with id " + id + " was not found!"));

    }

    @Override
    public List<Cart> findAll()
    {

        return cartRepository.findAll();

    }

    void validate(Cart order)
    {
        if (isDuplicatedOrder(order)) {
             throw new ValidationException("There is another cart with the same order. Please place a different order.");

        }
    }

    boolean isDuplicatedOrder(Cart order)
    {

            return cartRepository
                .findByCriteria("customerID", order.getCustomerID())
                .filter(c -> !c.getCartID().equals(order.getCartID()))
                .isPresent();


    }

    public double calculateTotal()      // may remove this
    {
        double x = 0.0;

        return  x;
    }

    public void printSummary()          // may remove this
    {

    }

    public void placeOrder(int custOrderID)
    {
        //save order in database (history)
        // add item to shopping cart
        // direct user to order summary page
    }

    public void cancelOrder(int custOrderID)
    {
        // opposite of place_Order
    }

    @Override
    public Optional<Cart> findByCriteria(String field, String criteria){


        return cartRepository.findByCriteria(field, criteria);
    }
}

