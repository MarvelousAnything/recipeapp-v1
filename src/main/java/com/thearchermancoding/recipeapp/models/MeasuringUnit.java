package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * The type Measuring unit.
 */
@Entity
@Table(name = "measuring_unit")
@Data
@NoArgsConstructor
public class MeasuringUnit {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private long id;

    @NonNull
    @Column(name = "unit_name", nullable = false, length = 50)
    private String unitName;

    @NonNull
    @Column(name = "unit_variable", nullable = false, length = 10)
    private String unitVariable;
}
