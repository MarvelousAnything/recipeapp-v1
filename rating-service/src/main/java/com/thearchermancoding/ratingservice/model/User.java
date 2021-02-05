package com.thearchermancoding.ratingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * The type Recipe user.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
