package com.cayla.fondue.school.dto;

import jakarta.validation.constraints.NotEmpty;

// This is the DTO that will be used to create a new School entity
// This is to ensure that the client does not have to know about the internal structure of the School entity
public record SchoolDto(
                @NotEmpty String schoolName,
                @NotEmpty String address) {

}
