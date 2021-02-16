package com.thearchermancoding.ingredientservice.model;

import lombok.*;

import javax.persistence.*;

/**
 * The type Ingredient.
 */
@Entity
@Table(name = "ingredient")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_generator")
    @SequenceGenerator(name = "ingredient_generator", sequenceName = "ingredient_sequence")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;

    @NonNull
    @Column(name = "description")
    private String description;
}
