package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.MeasuringUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeasuringUnitRepository extends JpaRepository<MeasuringUnit, Integer>, JpaSpecificationExecutor<MeasuringUnit> {

}