package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.RecipeUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeUserRepository extends CrudRepository<RecipeUser, Long>, JpaSpecificationExecutor<RecipeUser> {
}