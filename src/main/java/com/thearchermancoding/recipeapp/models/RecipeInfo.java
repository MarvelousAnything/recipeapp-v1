package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * The type Recipe info.
 */
@Entity
@Table(name = "recipe_info")
@Data
@NoArgsConstructor
public class RecipeInfo {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    /**
     * The Steps.
     */
    @JoinColumn(name = "step_id", nullable = false)
    @OneToMany
    List<Step> steps;

    @NonNull
    @JoinColumn(name = "ingredient_id", nullable = false)
    @ManyToMany
    private List<RecipeIngredient> ingredients;

    @NonNull
    @JoinColumn(name = "author_id", nullable = false)
    @ManyToOne
    private RecipeUser author;

    @Column(name = "prep_time")
    private int prepTime;

    @NonNull
    @JoinColumn(name = "recipe_id", nullable = false, unique = true)
    @ManyToOne
    private Recipe recipe;

    @Column(name = "servings")
    private int servings;

}
