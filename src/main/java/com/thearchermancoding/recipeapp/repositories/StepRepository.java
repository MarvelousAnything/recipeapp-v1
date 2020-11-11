package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StepRepository extends JpaRepository<Step, Integer>, JpaSpecificationExecutor<Step> {

}