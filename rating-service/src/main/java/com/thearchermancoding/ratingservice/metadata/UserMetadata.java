package com.thearchermancoding.ratingservice.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMetadata extends RepresentationModel<UserMetadata> {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
