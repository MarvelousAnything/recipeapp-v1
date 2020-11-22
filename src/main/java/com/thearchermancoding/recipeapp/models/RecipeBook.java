package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_book_generator")
    @SequenceGenerator(name = "recipe_book_generator", sequenceName = "recipe_book_sequence")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @NonNull
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @JoinTable(
            name = "recipe_book_recipes",
            joinColumns = @JoinColumn(
                    name = "recipe_book_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "recipe_id",
                    referencedColumnName = "id"
            )

    )
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Recipe> recipes = new ArrayList<Recipe>();

    @JoinColumn(name = "owner_id")
    @ManyToOne
    private RecipeUser owner;
}
