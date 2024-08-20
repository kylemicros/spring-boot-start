package com.cayla.fondue.student.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cayla.fondue.student.dto.StudentDto;
import com.cayla.fondue.student.dto.StudentResponseDto;
import com.cayla.fondue.student.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
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

    @GetMapping("/search/{student-last-name}")
    public List<StudentResponseDto> findStudentByLastName(
            @PathVariable("student-last-name") String lastName) {
        return studentService.findAllByLastNameContaining(lastName);

    }

    // This is a custom exception handler that will catch
    // MethodArgumentNotValidException
    // and return a map of errors in the response body.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exc) {
        var errors = new HashMap<String, String>();
        exc.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }
}
