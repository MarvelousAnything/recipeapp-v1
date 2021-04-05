package com.thearchermancoding.recipeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * The type Step.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "step", uniqueConstraints =
    @UniqueConstraint(columnNames = {"recipe_id", "step_number"})
)
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "step_generator")
    @GenericGenerator(name = "step_generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true, updatable = false)
    private UUID id;

    @NonNull
    @ManyToOne(targetEntity = Recipe.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @NonNull
    @Column(name = "instruction")
    private String instruction;

    @NonNull
    @Column(name = "step_number", nullable = false)
    private Integer stepNumber;

}
