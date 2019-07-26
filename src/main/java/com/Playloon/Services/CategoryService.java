package com.Playloon.Services;

import com.Playloon.Entities.Category;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Model.CategoryRepository;
import com.Playloon.Model.Repository;
import com.Playloon.Exceptions.ValidationException;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


public class CategoryService implements Service<Category>{

    // No Business Rules

    // check business rules
    // call respective repository functions
    // CategoryRepository categegoryRep = new CategoryRepository();

    private Repository<Category> categegoryRep;

    public CategoryService()
    {
        categegoryRep = new CategoryRepository();
    }

    public CategoryService(Repository<Category> categegoryRep)
    {
        this.categegoryRep = new CategoryRepository();              // ask alex about this
    }


    @Override
    public void add(Category category)
    {
        validate(category);     // check for duplicates , get error here
        categegoryRep.add(category); // call CategoryRepository
    }

    @Override
    public void remove(String id)
    {
       // Category toDelete = findByID(id);
       // categegoryRep.remove(toDelete);      // calling repository

        categegoryRep.remove(categegoryRep
                .findByID(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Category with id " + id + " was not found!")));

    }

    @Override
    public void update(Category category)
    {

        categegoryRep
                .findByID(category.getcategoryID())
                .orElseThrow(
                        () -> new EntityNotFoundException("Category with id " + category.getcategoryID() + " was not found!"));

        validate(category);
        categegoryRep.update(category);

        /*
        Category categoryToUpdate = findByID(category.getCatID());     // calling the findByID method in Service

        validate(categoryToUpdate);
        if(categoryToUpdate != null)
        {
            categegoryRep.update(category);      // calling repository

        }
        */
    }

    @Override
    public Category findByID(String id)
    {

        return categegoryRep.findByID(id).orElseThrow(()-> new NoSuchElementException("Category not found"));
    }

    @Override
    public List<Category> findAll()
    {
        // get from database

        return categegoryRep.findAll();

    }

    void validate(Category category)
    {
        if (isDuplicatedCategory(category)) {
            throw new ValidationException("There is another category with the same plate, please, choose another one");

            // Throw exception
        }

    }

    boolean isDuplicatedCategory(Category category)
    {

          return categegoryRep
                .findByCriteria("categoryName", category.getCategoryName())
                .filter(c -> !c.getcategoryID().equals(category.getcategoryID()))
                .isPresent();

    }

    @Override
    public Optional<Category> findByCriteria(String field, String criteria){


        return categegoryRep.findByCriteria(field, criteria);
    }


}
