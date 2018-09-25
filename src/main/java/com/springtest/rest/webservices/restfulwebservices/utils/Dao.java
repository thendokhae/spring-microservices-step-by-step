package com.springtest.rest.webservices.restfulwebservices.utils;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(Integer id);

    List<T> getAll();

    T save(T t);

    void update(T t);

    T delete(Integer id);
}
