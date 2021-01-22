package com.thearchermancoding.recipeapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * The type Step.
 */
@Entity
@Table(name = "step", uniqueConstraints =
    @UniqueConstraint(columnNames = {"recipe_id", "step_number"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "step_generator")
    @SequenceGenerator(name = "step_generator", sequenceName = "step_sequence")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @NonNull
    @ManyToOne(targetEntity = Recipe.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @NonNull
    @JoinTable(
            name = "step_ingredient",
            joinColumns = @JoinColumn(name = "step_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    )
    @ManyToMany(targetEntity = RecipeIngredient.class)
    private List<RecipeIngredient> ingredients;

    @NonNull
    @Column(name = "instruction")
    private String instruction;

    @NonNull
    @Column(name = "step_number", nullable = false)
    private Integer stepNumber;

}
