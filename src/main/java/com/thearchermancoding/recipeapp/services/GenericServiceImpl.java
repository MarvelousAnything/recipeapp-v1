package com.thearchermancoding.recipeapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    @Autowired
    private CrudRepository<T, ID> repository;

    @Override
    public <S extends T> S save(S entity) {
        return repository.save(entity);
    }
}