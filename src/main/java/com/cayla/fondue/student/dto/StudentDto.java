package com.cayla.fondue.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

// This is the DTO that will be used to create a new Student entity
// This is to ensure that the client does not have to know about the internal structure of the Student entity
public record StudentDto(
                @NotEmpty(message = "First name should not be empty!") String firstName,
                @NotEmpty(message = "Last name should not be empty!") String lastName,
                @NotEmpty(message = "Email should not be empty!") @Email String email,
                @NotEmpty(message = "School ID must not be empty!") Long schoolId) {

}
