package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * The type Rating.
 */
@Entity
@Table(name = "rating")
@Data
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_generator")
    @SequenceGenerator(name = "rating_generator", sequenceName = "rating_sequence")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @NonNull
    @JoinColumn(name = "recipe_id")
    @ManyToOne
    private Recipe recipe;

    @NonNull
    @JoinColumn(name = "reviewer_id")
    @ManyToOne
    private RecipeUser user;

    @NonNull
    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "review")
    private String review;

}
