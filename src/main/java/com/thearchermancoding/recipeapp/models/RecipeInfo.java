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
//    @JoinColumn(name = "step_id", nullable = false)
//    @OneToMany(targetEntity = Step.class)    // TODO: Needs to be @OneToMany. Unidirectional with @JoinTable? https://docs.jboss.org/hibernate/stable/annotations/reference/en/html/entity.html#entity-mapping-association-collections
//    private List<Step> steps;

    @NonNull
    @JoinColumn(name = "ingredient_id", nullable = false) // TODO: I probably can get rid of ingredients. All of the ingredients should be included in step. // TODO: make it so it isn't updatable
    // TODO: I may benefit from a bidirectional relationship with RecipeIngredient
    @ManyToOne(targetEntity = RecipeIngredient.class)     // TODO: See if I can get many to many to work how I want it.
    private RecipeIngredient ingredients;

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
