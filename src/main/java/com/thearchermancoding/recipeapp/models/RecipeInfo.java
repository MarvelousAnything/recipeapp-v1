package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * The type Recipe info.
 * TODO: Deletions should cascade for recipe and steps. Not Ingredients.
 */
@Entity
@Table(name = "recipe_info")
@Data
@NoArgsConstructor
public class RecipeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_info_generator")
    @SequenceGenerator(name = "recipe_info_generator", sequenceName = "recipe_info_sequence")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    /**
     * The Steps.
     */
    @JoinTable(
            name = "recipe_info_steps",
            joinColumns = @JoinColumn(name = "recipe_info_id"),
            inverseJoinColumns = @JoinColumn(name = "step_id")
    )
    @OneToMany(targetEntity = Step.class)    // TODO: Needs to be @OneToMany. Unidirectional with @JoinTable? https://docs.jboss.org/hibernate/stable/annotations/reference/en/html/entity.html#entity-mapping-association-collections
    private List<Step> steps;


    @NonNull
    @JoinTable(
            name = "recipe_info_and_recipe_ingredients",
            joinColumns = @JoinColumn(name = "recipe_ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_info_id")
    )
    @ManyToMany(targetEntity = RecipeIngredient.class)
    private List<RecipeIngredient> ingredients;     // TODO: I probably should get rid of this column


    @NonNull
    @JoinColumn(name = "author_id", nullable = false) // TODO: Either get rid of this of the author join column in Recipe
    @ManyToOne(targetEntity = RecipeUser.class)
    private RecipeUser author;

    @Column(name = "prep_time")
    private int prepTime;

    @NonNull
    @JoinColumn(name = "recipe_id", nullable = false, unique = true)
    @ManyToOne(targetEntity = Recipe.class)
    private Recipe recipe;

    @Column(name = "servings")
    private int servings;

}
