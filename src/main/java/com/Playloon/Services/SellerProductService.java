package com.Playloon.Services;

import com.Playloon.Entities.SellerProduct;
import com.Playloon.Entities.Sellers;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Exceptions.ValidationException;
import com.Playloon.Model.Repository;
import com.Playloon.Model.SellerProductRepository;

import java.util.List;
import java.util.Optional;

public class SellerProductService implements Service<SellerProduct> {

    /* To be improvised */

    private Repository<SellerProduct> sellerProductRepository;

    public SellerProductService()
    {
        sellerProductRepository = new SellerProductRepository();
    }

    public SellerProductService(Repository<SellerProduct> sellerProductRepository) {

        this.sellerProductRepository = new SellerProductRepository();              // ask alex about this
    }

    @Override
    public void add(SellerProduct sellerproduct) {

        sellerProductRepository.add(sellerproduct); // call CategoryRepository
    }

    @Override
    public void remove(String id)
    {
        sellerProductRepository.remove(sellerProductRepository
                .findByID(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("sellerproduct with id " + id + " was not found!"))
        );

    }

    @Override
    public void update(SellerProduct sellerproduct)
    {
        sellerProductRepository
                .findByID(sellerproduct.getSellerID())
                .orElseThrow(
                        () -> new EntityNotFoundException("Seller with id " + sellerproduct.getSellerID() + " was not found!"));

        validate(sellerproduct);
        sellerProductRepository.update(sellerproduct);
    }

    @Override
    public SellerProduct findByID(String id)
    {

        return sellerProductRepository.findByID(id).orElseThrow(() -> new EntityNotFoundException("Cart with id " + id + " was not found!"));

    }

    @Override
    public List<SellerProduct> findAll()
    {

        return sellerProductRepository.findAll();

    }

    void validate(SellerProduct sellerproduct)
    {
        if (isDuplicatedSeller(sellerproduct)) {
            throw new ValidationException("There is another seller with the same order. Please place a different order.");

        }
    }

    boolean isDuplicatedSeller(SellerProduct sellerproduct)
    {

        return sellerProductRepository
                .findByCriteria("FullName", sellerproduct.getSellerID())
                .filter(c -> !c.getSellerID().equals(sellerproduct.getSellerID()))
                .isPresent();


    }

    @Override
    public Optional<SellerProduct> findByCriteria(String field, String criteria){


        return sellerProductRepository.findByCriteria(field, criteria);
    }

}
