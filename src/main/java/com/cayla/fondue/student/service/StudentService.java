package com.cayla.fondue.student.service;

import org.springframework.stereotype.Service;

import com.cayla.fondue.student.dto.StudentDto;
import com.cayla.fondue.student.dto.StudentResponseDto;
import com.cayla.fondue.student.entity.Student;
import com.cayla.fondue.student.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapperService studentMapperService;

    public StudentResponseDto saveStudent(StudentDto studentDto) {
        Student student = studentMapperService.createStudent(studentDto);

        return studentMapperService.createStudentResponseDto(studentRepository.save(student));
    }

    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapperService::createStudentResponseDto)
                .collect(Collectors.toList());
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public StudentResponseDto findById(Long id) {
        return studentRepository.findById(id).map(studentMapperService::createStudentResponseDto).orElse(null);
    }

    public List<StudentResponseDto> findAllByFirstNameContaining(String firstName) {
        return studentRepository.findAllByFirstNameContaining(firstName).stream()
                .map(studentMapperService::createStudentResponseDto)
                .collect(Collectors.toList());
    }
}
