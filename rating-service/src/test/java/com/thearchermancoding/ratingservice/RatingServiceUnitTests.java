package com.thearchermancoding.ratingservice;

import com.thearchermancoding.ratingservice.model.Rating;
import com.thearchermancoding.ratingservice.repository.RatingRepository;
import com.thearchermancoding.ratingservice.service.RatingService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {"eureka.client.enable=false", "eureka.client.fetch-registry=false", "eureka.client.register-with-eureka=false"})
class RatingServiceUnitTests {

    @InjectMocks
    private RatingService ratingService;

    @Mock
    private RatingRepository ratingRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void givenRatingServiceWhenQueriedWithAnIdThenGetExpectedRating() {
        Rating rating = new Rating(100L, 50L, 25L, 5.0, "Good Recipe!");
        Mockito.when(ratingRepository.findById(100L))
                .thenReturn(Optional.of(rating));

        Rating result = ratingService.findById(100L).orElse(null);

        assertThat(result).isNotNull();
        assertThat(rating.getReview()).isEqualTo(result.getReview());
        assertThat(rating.getRating()).isEqualTo(result.getRating());
        assertThat(rating.getRecipeId()).isEqualTo(result.getRecipeId());
        assertThat(rating.getReviewerId()).isEqualTo(result.getReviewerId());
    }

}
