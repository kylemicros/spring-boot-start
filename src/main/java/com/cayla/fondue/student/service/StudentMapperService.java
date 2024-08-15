package com.cayla.fondue.student.service;

import org.springframework.stereotype.Service;

import com.cayla.fondue.student.dto.StudentDto;
import com.cayla.fondue.student.dto.StudentResponseDto;
import com.cayla.fondue.student.entity.Student;
import com.cayla.fondue.school.entity.School;
import com.cayla.fondue.school.repository.SchoolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentMapperService {
    private final SchoolRepository schoolRepository;

    public Student createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());

        School school = schoolRepository.findById(studentDto.schoolId())
                .orElseThrow(() -> new RuntimeException("School not found"));

        student.setSchool(school);
        return student;
    }

    public StudentResponseDto createStudentResponseDto(Student student) {
        return new StudentResponseDto(student.getFirstName(), student.getLastName(), student.getEmail());
    }
}
