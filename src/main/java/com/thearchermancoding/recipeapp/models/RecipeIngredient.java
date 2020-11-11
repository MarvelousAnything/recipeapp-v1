package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * The type Recipe ingredient.
 */
@Entity
@Table(name = "recipe_ingredient")
@Data
@NoArgsConstructor
public class RecipeIngredient {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private MeasuringUnit unit;

    @NonNull
    @Column(name = "amount", nullable = false)
    private float amount;
}
