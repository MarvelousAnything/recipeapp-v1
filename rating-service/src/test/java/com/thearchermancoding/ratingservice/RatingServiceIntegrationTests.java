package com.thearchermancoding.ratingservice;

import com.thearchermancoding.ratingservice.controller.RatingController;
import com.thearchermancoding.ratingservice.model.Rating;
import com.thearchermancoding.ratingservice.repository.RatingRepository;
import com.thearchermancoding.ratingservice.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {"eureka.client.enable=false", "eureka.client.fetch-registry=false", "eureka.client.register-with-eureka=false"})
@WebAppConfiguration
@AutoConfigureMockMvc
public class RatingServiceIntegrationTests {

    @Mock
    private RatingService ratingService;

    @InjectMocks
    private RatingController ratingController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(ratingController).build();
        Mockito.when(ratingService.findById(100L)).thenReturn(java.util.Optional.of(new Rating(100L, 50L, 25L, 5.0, "is food")));
    }

    @Test
    public void TestRatingServicePostRequest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/ratings")
                .contentType("application/json")
                .content("{\t\"recipeId\": 100,\n\t\"reviewerId\": 50,\n\t\"rating\": 5,\n\t\"review\": \"is food\"\n}"))
        .andDo(print())
        .andExpect(status().isCreated());
    }

    @Test
    public void TestRatingServiceGetAllRequest() throws Exception {

    }
}
