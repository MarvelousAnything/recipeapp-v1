package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.RecipeBook;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeBookRepository extends CrudRepository<RecipeBook, Long>, JpaSpecificationExecutor<RecipeBook> {

}