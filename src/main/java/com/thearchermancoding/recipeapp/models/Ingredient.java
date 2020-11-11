package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * The type Ingredient.
 */
@Entity
@Table(name = "ingredient")
@Data
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "id", unique = true)
    private long id;

    @NonNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NonNull
    @Column(name = "description")
    private String description;
}
