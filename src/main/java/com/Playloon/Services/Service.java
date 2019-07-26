package com.Playloon.Services;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

  void add(T t);

  void remove(String id);

  void update(T t);

  T findByID(String id);

  Optional<T> findByCriteria(String field, String criteria);

  List<T> findAll();


}
