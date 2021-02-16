package com.thearchermancoding.ingredientservice.repository;

import com.thearchermancoding.ingredientservice.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryRestResource(exported = false)
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findDistinctByName(String name);
}
