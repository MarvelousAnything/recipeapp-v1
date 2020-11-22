package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.MeasuringUnit;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasuringUnitRepository extends CrudRepository<MeasuringUnit, Long>, JpaSpecificationExecutor<MeasuringUnit> {

}