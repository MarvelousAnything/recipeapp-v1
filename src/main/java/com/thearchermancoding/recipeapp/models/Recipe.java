package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * The type Recipe.
 */
@Entity
@Table(name = "recipe")
@Data
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private long id;

    @NonNull
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @NonNull
    @JoinColumn(name = "author_id", nullable = false)
    @ManyToOne
    private RecipeUser author;
}
