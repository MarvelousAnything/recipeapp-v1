package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * The type Recipe book.
 */
@Entity
@Table(name = "recipe_book")
@Data
@NoArgsConstructor
public class RecipeBook {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @JoinColumn(name = "recipe_id")
    @ManyToMany
    private List<Recipe> recipes;

    @JoinColumn(name = "owner_id")
    @ManyToOne
    private RecipeUser owner;
}
