package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * The type Recipe user.
 */
@Entity
@Table(name = "recipe_user")
@Data
@NoArgsConstructor
public class RecipeUser {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private long id;

    @NonNull
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;
}
