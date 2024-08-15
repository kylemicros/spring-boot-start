package com.cayla.fondue.school.service;

import org.springframework.stereotype.Service;

import com.cayla.fondue.school.dto.SchoolDto;
import com.cayla.fondue.school.entity.School;

@Service
public class SchoolMapperService {
    public School createSchool(SchoolDto schoolDto) {
        return new School(schoolDto.schoolName(), schoolDto.address());
    }

    public SchoolDto getSchoolDto(School school) {
        return new SchoolDto(school.getSchoolName(), school.getAddress());
    }
}
