package com.thearchermancoding.ingredientservice.repository;

import com.thearchermancoding.ingredientservice.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryRestResource(exported = false)
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}