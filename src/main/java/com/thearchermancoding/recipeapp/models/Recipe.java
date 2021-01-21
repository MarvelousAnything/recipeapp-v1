package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * The type Recipe.
 */
@Entity
@Table(name = "recipe")
@Data
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_generator")
    @SequenceGenerator(name = "recipe_generator", sequenceName = "recipe_sequence")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @NonNull
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "description")
    private String description;

    @NonNull
    @JoinColumn(name = "author_id", nullable = false)
    @ManyToOne(targetEntity = RecipeUser.class)
    private RecipeUser author;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    private List<Step> steps;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    private List<Rating> ratings;

    @Column(name = "prep_time")
    private int prepTime;

    @Column(name = "servings")
    private int servings;
}
