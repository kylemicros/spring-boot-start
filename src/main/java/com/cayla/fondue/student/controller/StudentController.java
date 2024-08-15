package com.cayla.fondue.student.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cayla.fondue.student.dto.StudentDto;
import com.cayla.fondue.student.dto.StudentResponseDto;
import com.cayla.fondue.student.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public StudentResponseDto saveStudent(
            @Valid @RequestBody StudentDto studentDto) {
        return this.studentService.saveStudent(studentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(
            @PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(
            @PathVariable("id") Long id) {
        return studentService.findById(id);

    }

    @GetMapping("/search/{student-name}")
    public List<StudentResponseDto> findStudentByName(
            @PathVariable("student-name") String name) {
        return studentService.findAllByFirstNameContaining(name);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(
            MethodArgumentNotValidException exc) {
        return ResponseEntity.badRequest().body(exc.getBindingResult().getAllErrors());
    }
}
