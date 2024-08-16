package com.cayla.fondue.school.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cayla.fondue.school.dto.SchoolDto;
import com.cayla.fondue.school.entity.School;
import com.cayla.fondue.school.service.SchoolService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    public SchoolDto post(@Valid @RequestBody SchoolDto schoolDto) {
        return this.schoolService.saveSchool(schoolDto);
    }

    @GetMapping
    public List<SchoolDto> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}")
    public School findSchoolById(@PathVariable("id") Long id) {
        return schoolService.findSchoolById(id);
    }

    @GetMapping("/search")
    public List<SchoolDto> findSchoolByName(@RequestParam("name") String name) {
        return schoolService.findSchoolByName(name);
    }

    @PutMapping("/{id}")
    public School updateSchool(@PathVariable("id") Long id, @Valid @RequestBody School school) {
        return schoolService.updateSchool(id, school);
    }

    @DeleteMapping("/{id}")
    public void deleteSchoolById(@PathVariable("id") Long id) {
        schoolService.deleteSchool(id);
    }
}
