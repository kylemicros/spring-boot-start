package com.cayla.fondue.school.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cayla.fondue.school.dto.SchoolDto;
import com.cayla.fondue.school.entity.School;
import com.cayla.fondue.school.repository.SchoolRepository;
import com.cayla.fondue.school.service.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapperService schoolMapperService;

    public SchoolDto saveSchool(SchoolDto schoolDto) {
        School school = schoolMapperService.createSchool(schoolDto);

        schoolRepository.save(school);
        return schoolDto;
    }

    public List<SchoolDto> getAllSchools() {
        return schoolRepository.findAll().stream().map(schoolMapperService::getSchoolDto).collect(Collectors.toList()); // this
                                                                                                                        // is
                                                                                                                        // a
                                                                                                                        // lambda
                                                                                                                        // expression
                                                                                                                        // that
                                                                                                                        // takes
                                                                                                                        // a
                                                                                                                        // school
                                                                                                                        // object
                                                                                                                        // and
                                                                                                                        // returns
                                                                                                                        // a
                                                                                                                        // schoolDto
                                                                                                                        // object
    }

    public School findSchoolById(@PathVariable("id") Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public void deleteSchool(@PathVariable("id") Long id) {
        schoolRepository.deleteById(id);
    }

    public List<SchoolDto> findSchoolByName(String name) {
        return schoolRepository.findBySchoolName(name).stream().map(schoolMapperService::getSchoolDto)
                .collect(Collectors.toList());
    }

    public School updateSchool(Long id, School school) {
        School schoolToUpdate = schoolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("School not found"));
        schoolToUpdate.setSchoolName(school.getSchoolName());
        schoolToUpdate.setAddress(school.getAddress());
        schoolRepository.save(schoolToUpdate);
        return schoolToUpdate;
    }
}
