package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * The type Step.
 */
@Entity
@Table(name = "step")
@Data
@NoArgsConstructor
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "step_generator")
    @SequenceGenerator(name = "step_generator", sequenceName = "step_sequence")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @NonNull
    @JoinColumn(name = "ingredient_id", nullable = false)
    @ManyToOne(targetEntity = RecipeIngredient.class)   // TODO: Make it so I can use a many to many relationship
    private RecipeIngredient ingredients;

    @NonNull
    @Column(name = "instruction")
    private String instruction;

    @ManyToOne(targetEntity = Recipe.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}
