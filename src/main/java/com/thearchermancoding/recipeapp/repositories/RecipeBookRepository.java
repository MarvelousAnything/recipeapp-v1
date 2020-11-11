package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.RecipeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecipeBookRepository extends JpaRepository<RecipeBook, Integer>, JpaSpecificationExecutor<RecipeBook> {

}