package com.Playloon.Services;

import com.Playloon.Entities.Item;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Model.ItemRepository;
import com.Playloon.Model.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemService implements Service<Item> {

    private Repository<Item> itemRepository;

    private List<Item> items = new ArrayList<Item>();

    public ItemService()
    {
        itemRepository = new ItemRepository();
    }

    public ItemService(Repository<Item> itemRepository)
    {
        this.itemRepository = new ItemRepository();              // ask alex about this
    }


    @Override
    public void add(Item item)
    {
        itemRepository.add(item); // call CategoryRepository
    }

    @Override
    public void remove(String id)
    {
        itemRepository.remove(itemRepository
                .findByID(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Cart with id " + id + " was not found!"))
        );

    }

    @Override
    public void update(Item item)
    {
        itemRepository
                .findByID(item.getCartID())
                .orElseThrow(
                        () -> new EntityNotFoundException("Car with id " + item.getCartID() + " was not found!"));

        itemRepository.update(item);
    }

    @Override
    public Item findByID(String id)
    {

        return itemRepository.findByID(id).orElseThrow(() -> new EntityNotFoundException("Cart with id " + id + " was not found!"));

    }

    @Override
    public List<Item> findAll()
    {
        return itemRepository.findAll();

    }

    void validate(Item item)
    {

    }

    boolean isDuplicatedOrder(Item order)
    {


        return true;
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
    public Optional<Item> findByCriteria(String field, String criteria){


        return itemRepository.findByCriteria(field, criteria);
    }
}
