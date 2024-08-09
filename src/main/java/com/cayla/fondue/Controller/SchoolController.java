package com.cayla.fondue.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cayla.fondue.entity.School;
import com.cayla.fondue.repository.SchoolRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolRepository schoolRepository;

    @PostMapping("/schools")
    public School createSchool(@RequestBody School school) {
        return schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }
}
