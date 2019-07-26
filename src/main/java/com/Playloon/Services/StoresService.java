package com.Playloon.Services;

import com.Playloon.Entities.Stores;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Exceptions.ValidationException;
import com.Playloon.Model.Repository;
import com.Playloon.Model.StoresRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StoresService implements Service<Stores>{

    private Repository<Stores> storesRepository;

    private List<Stores> stores = new ArrayList<Stores>();

    public StoresService()
    {
        storesRepository = new StoresRepository();
    }

    public StoresService(Repository<Stores> storesRepository)
    {
        this.storesRepository = new StoresRepository();              // ask alex about this
    }


    @Override
    public void add(Stores stores)
    {
        validate(stores);     // check business rules and duplicates
        storesRepository.add(stores); // call CategoryRepository
    }

    @Override
    public void remove(String id)
    {
        storesRepository.remove(storesRepository
                .findByID(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Store with id " + id + " was not found!"))
        );

    }

    @Override
    public void update(Stores stores)
    {
        storesRepository
                .findByID(stores.getStoreID())
                .orElseThrow(
                        () -> new EntityNotFoundException("Store with id " + stores.getStoreID() + " was not found!"));

        validate(stores);
        storesRepository.update(stores);
    }

    @Override
    public Stores findByID(String id)
    {

        return storesRepository.findByID(id).orElseThrow(() -> new EntityNotFoundException("Store with id " + id + " was not found!"));

    }

    @Override
    public List<Stores> findAll()
    {

        return storesRepository.findAll();

    }

    void validate(Stores stores)
    {
        if (isDuplicatedStore(stores)) {
            throw new ValidationException("There is another Store with the same details. Please create a new store.");

        }
    }

    boolean isDuplicatedStore(Stores stores)
    {

        return storesRepository
                .findByCriteria("storeName", stores.getStoreName())
                .filter(c -> !c.getStoreID().equals(stores.getStoreID()))
                .isPresent();
    }

    @Override
    public Optional<Stores> findByCriteria(String field, String criteria){


        return storesRepository.findByCriteria(field, criteria);
    }
}
