package com.example.validate.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;

    @Pattern(regexp = "^0[0-9]{9,10}$", message = "Địng dạng không hợp lệ")
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi ít nhất là 18")
    private int age;

    @Email
    @NotBlank
    private String email;
}
