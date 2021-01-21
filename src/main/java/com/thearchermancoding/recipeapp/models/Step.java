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
    @JoinTable(
            name = "step_ingredient",
            joinColumns = @JoinColumn(name = "step_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    )
    @ManyToMany(targetEntity = RecipeIngredient.class)
    private List<RecipeIngredient> ingredients;

    @NonNull
    @Column(name = "instruction")
    private String instruction;

    @ManyToOne(targetEntity = Recipe.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}
