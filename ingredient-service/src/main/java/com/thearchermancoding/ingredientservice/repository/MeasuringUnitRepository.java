package com.thearchermancoding.ingredientservice.repository;

import com.thearchermancoding.ingredientservice.model.MeasuringUnit;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryRestResource(exported = false)
public interface MeasuringUnitRepository extends JpaRepository<MeasuringUnit, Long> {
    Optional<MeasuringUnit> findDistinctByUnitName(String unitName);

    Optional<MeasuringUnit> findDistinctByUnitVariable(String unitVariable);

    Optional<MeasuringUnit> findDistinctByUnitVariableAndUnitName(@NonNull String unitVariable, @NonNull String unitName);
}