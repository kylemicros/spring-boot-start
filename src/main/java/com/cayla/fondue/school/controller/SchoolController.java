package com.cayla.fondue.school.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cayla.fondue.school.dto.SchoolDto;
import com.cayla.fondue.school.entity.School;
import com.cayla.fondue.school.service.SchoolService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping("/schools")
    public SchoolDto post(@RequestBody SchoolDto schoolDto) {
        return this.schoolService.post(schoolDto);
    }

    @GetMapping("/schools")
    public List<SchoolDto> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/schools/{id}")
    public School findSchoolById(@PathVariable("id") Long id) {
        return schoolService.findSchoolById(id);
    }

    @DeleteMapping("/schools/{id}")
    public void deleteSchoolById(@PathVariable("id") Long id) {
        schoolService.deleteSchool(id);
    }
}
