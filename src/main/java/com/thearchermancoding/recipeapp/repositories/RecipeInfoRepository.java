package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.RecipeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecipeInfoRepository extends JpaRepository<RecipeInfo, Integer>, JpaSpecificationExecutor<RecipeInfo> {

}