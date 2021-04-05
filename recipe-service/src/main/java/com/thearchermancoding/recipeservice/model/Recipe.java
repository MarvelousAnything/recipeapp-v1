package com.thearchermancoding.recipeservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * The type Recipe.
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "recipe")
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

    private UUID authorId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    private List<Step> steps;

    @Column(name = "prep_time")
    private int prepTime;

    @Column(name = "servings")
    private int servings;
}
