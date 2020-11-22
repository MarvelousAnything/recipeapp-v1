package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.Step;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends CrudRepository<Step, Long>, JpaSpecificationExecutor<Step> {

}