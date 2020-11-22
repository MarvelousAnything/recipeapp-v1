package com.thearchermancoding.recipeapp.services;

import com.thearchermancoding.recipeapp.models.Ingredient;
import com.thearchermancoding.recipeapp.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class IngredientServiceImpl extends GenericServiceImpl<Ingredient, Long> implements IngredientService {
    private final IngredientRepository repository;

    @Autowired
    IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<Ingredient> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Ingredient> findAllById(Iterable<Long> id) {
        return repository.findAllById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Ingredient ingredient) {
        repository.delete(ingredient);
    }

    @Override
    public void deleteAll(Iterable<? extends Ingredient> ingredients) {
        repository.deleteAll(ingredients);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
