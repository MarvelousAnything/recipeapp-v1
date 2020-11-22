package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.Ingredient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RepositoryRestResource(path="ingredients")
public interface IngredientRepository extends CrudRepository<Ingredient, Long>, JpaSpecificationExecutor<Ingredient> {
}
