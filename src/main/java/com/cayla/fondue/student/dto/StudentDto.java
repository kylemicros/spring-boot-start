package com.cayla.fondue.student.dto;

import jakarta.validation.constraints.NotEmpty;

// This is the DTO that will be used to create a new Student entity
// This is to ensure that the client does not have to know about the internal structure of the Student entity
public record StudentDto(
        @NotEmpty String firstName,
        @NotEmpty String lastName,
        String email,
        Long schoolId) {

}
