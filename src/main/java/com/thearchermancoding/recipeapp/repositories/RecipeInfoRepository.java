package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.RecipeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "recipeInfo")
public interface RecipeInfoRepository extends CrudRepository<RecipeInfo, Long>, JpaSpecificationExecutor<RecipeInfo> {
}