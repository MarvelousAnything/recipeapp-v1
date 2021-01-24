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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_ingredient_generator")
    @SequenceGenerator(name = "recipe_ingredient_generator", sequenceName = "recipe_ingredient_sequence")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_id", nullable = false)
    private MeasuringUnit unit;

    @NonNull
    @Column(name = "amount", nullable = false)
    private float amount;
}
