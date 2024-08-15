package com.cayla.fondue.school.dto;

// This is the DTO that will be used to create a new School entity
// This is to ensure that the client does not have to know about the internal structure of the School entity
public record SchoolDto(
        String schoolName,
        String address) {

}
