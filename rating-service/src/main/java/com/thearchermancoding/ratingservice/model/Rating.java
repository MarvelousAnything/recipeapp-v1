package com.thearchermancoding.ratingservice.model;

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
    @Column(name = "recipe_id")
    private Long recipeId;

    @NonNull
    @Column(name = "reviewer_id")
    private Long reviewerId;

    @NonNull
    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "review")
    private String review;

}
