package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * The type Recipe user.
 */
@Entity
@Table(name = "recipe_user")
@Data
@NoArgsConstructor
public class RecipeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @NonNull
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Rating> ratings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Recipe> recipes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<RecipeBook> recipeBooks;
}
