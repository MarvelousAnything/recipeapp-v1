package com.thearchermancoding.ratingservice.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingMetadata extends RepresentationModel<RatingMetadata> {

    private Long id;

    private Long recipeId;

    private Long reviewerId;

    private Double rating;

    private String review;
}
