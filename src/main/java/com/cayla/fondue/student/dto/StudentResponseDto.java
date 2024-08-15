package com.cayla.fondue.student.dto;

// This is the DTO that will be returned to the client
// This is to ensure that the client does not have to know about the internal structure of the Student entity
public record StudentResponseDto(
        String firstName,
        String lastName,
        String email) {

}
