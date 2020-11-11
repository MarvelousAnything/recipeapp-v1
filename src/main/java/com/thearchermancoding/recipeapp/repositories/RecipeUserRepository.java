package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.RecipeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecipeUserRepository extends JpaRepository<RecipeUser, Integer>, JpaSpecificationExecutor<RecipeUser> {

}