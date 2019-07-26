package com.Playloon.Services;

import com.Playloon.Entities.Sellers;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Exceptions.ValidationException;
import com.Playloon.Model.Repository;
import com.Playloon.Model.SellersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SellersService implements Service<Sellers>{

    private Repository<Sellers> sellersRepository;

    private List<Sellers> sellers = new ArrayList<Sellers>();

    public SellersService()
    {
        sellersRepository = new SellersRepository();
    }

    public SellersService(Repository<Sellers> sellersRepository)
    {
        this.sellersRepository = new SellersRepository();              // ask alex about this
    }


    @Override
    public void add(Sellers seller)
    {
        validate(seller);     // check business rules and duplicates
        sellersRepository.add(seller); // call CategoryRepository
    }

    @Override
    public void remove(String id)
    {
        sellersRepository.remove(sellersRepository
                .findByID(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Seller with id " + id + " was not found!"))
        );

    }

    @Override
    public void update(Sellers seller)
    {
        sellersRepository
                .findByID(seller.getSellerID())
                .orElseThrow(
                        () -> new EntityNotFoundException("Seller with id " + seller.getSellerID() + " was not found!"));

        validate(seller);
        sellersRepository.update(seller);
    }

    @Override
    public Sellers findByID(String id)
    {

        return sellersRepository.findByID(id).orElseThrow(() -> new EntityNotFoundException("Cart with id " + id + " was not found!"));

    }

    @Override
    public List<Sellers> findAll()
    {

        return sellersRepository.findAll();

    }

    void validate(Sellers seller)
    {
        if (isDuplicatedSeller(seller)) {
            throw new ValidationException("There is another seller with the same order. Please place a different order.");

        }
    }

    boolean isDuplicatedSeller(Sellers seller)
    {

        return sellersRepository
                .findByCriteria("FullName", seller.getSellerName())
                .filter(c -> !c.getSellerID().equals(seller.getSellerID()))
                .isPresent();


    }

    @Override
    public Optional<Sellers> findByCriteria(String field, String criteria){


        return sellersRepository.findByCriteria(field, criteria);
    }
}
