package com.thearchermancoding.ratingservice.assembler;

import com.thearchermancoding.ratingservice.client.UserClient;
import com.thearchermancoding.ratingservice.metadata.RatingMetadata;
import com.thearchermancoding.ratingservice.model.Rating;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RatingMetadataAssembler extends RepresentationModelAssemblerSupport<Rating, RatingMetadata> {

    private final EntityLinks entityLinks;

    private final ModelMapper mapper;

    public RatingMetadataAssembler(EntityLinks entityLinks, ModelMapper mapper) {
        super(Rating.class, RatingMetadata.class);
        this.entityLinks = entityLinks;
        this.mapper = mapper;
    }

    @Override
    public RatingMetadata toModel(Rating rating) {
        RatingMetadata ratingMetadata = this.mapper.map(rating, RatingMetadata.class);
        Link selfLink = this.entityLinks.linkToItemResource(RatingMetadata.class, rating.getId()).withSelfRel();
        Link userLink = linkTo(methodOn(UserClient.class).getUserById(rating.getReviewerId())).withRel("reviewer");
        // TODO: Recipe Link
        // TODO: Link for the other ratings for the recipe / Link to recipe ratings (this could be done by linking to the recipe then from there to the related ratings)
        // TODO: Link to the next and previous ratings.
        ratingMetadata.add(selfLink, userLink);
        return ratingMetadata;
    }
}
