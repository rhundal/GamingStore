package com.Playloon.Model;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {        // Interface

    void add(T t);

    void update(T t);

    void remove(T t);

    Optional<T> findByID(String id);

    Optional<T> findByCriteria(String field, String criteria);

    List<T> findAll();


}