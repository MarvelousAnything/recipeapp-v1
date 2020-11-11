package com.thearchermancoding.recipeapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * The type Step.
 */
@Entity
@Table
@Data
@NoArgsConstructor
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true)
    private long id;

    @NonNull
    @JoinColumn(name = "ingredient_id", nullable = false)
    @ManyToMany()
    private List<RecipeIngredient> ingredients;

    @NonNull
    @Column(name = "instruction")
    private String instruction;

}
