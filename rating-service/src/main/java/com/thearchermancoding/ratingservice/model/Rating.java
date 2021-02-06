package com.thearchermancoding.ratingservice.model;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_generator")
    @SequenceGenerator(name = "rating_generator", sequenceName = "rating_sequence")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @Column(name = "recipe_id", nullable = false)
    private Long recipeId;

    @Column(name = "reviewer_id", nullable = false)
    private Long reviewerId;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @Column(name = "review")
    private String review;

}
