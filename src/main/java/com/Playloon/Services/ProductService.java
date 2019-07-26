package com.Playloon.Services;

import com.Playloon.Entities.Product;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Exceptions.ValidationException;
import com.Playloon.Model.ProductRepository;
import com.Playloon.Model.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ProductService implements Service<Product>{

    private Repository<Product> productRepository;

    public ProductService()
    {
        productRepository = new ProductRepository();
    }

    public ProductService(Repository<Product> productRepository)
    {
        this.productRepository = new ProductRepository();              // ask alex about this
    }


    @Override
    public void add(Product product)
    {
        validate(product);     // check for duplicates , get error here
        productRepository.add(product); // call CategoryRepository
    }

    @Override
    public void remove(String id)
    {

        productRepository.remove(productRepository
                .findByID(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Product with id " + id + " was not found!")));

    }

    @Override
    public void update(Product product)
    {

        productRepository
                .findByID(product.getProductID())
                .orElseThrow(
                        () -> new EntityNotFoundException("Car with id " + product.getProductID() + " was not found!"));

        validate(product);
        productRepository.update(product);

    }

    @Override
    public Product findByID(String id)
    {

        return productRepository.findByID(id).orElseThrow(()-> new NoSuchElementException("Product not found"));
    }

    @Override
    public List<Product> findAll()
    {
        // get from database

        return productRepository.findAll();

    }

    @Override
    public Optional<Product> findByCriteria(String field, String criteria){


        return productRepository.findByCriteria(field, criteria);
    }


    void validate(Product product)
    {
        if (isDuplicatedProduct(product)) {
            throw new ValidationException("There is another product with the same detals.");

            // Throw exception
        }

    }

    boolean isDuplicatedProduct(Product product)
    {

        return productRepository
                .findByCriteria("title", product.getTitle())
                .filter(c -> !c.getProductID().equals(product.getProductID()))
                .isPresent();

    }


}
