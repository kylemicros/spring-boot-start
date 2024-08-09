package com.cayla.fondue.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cayla.fondue.entity.Student;
import com.cayla.fondue.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("id") Long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(
            @PathVariable("id") Long id) {
        return studentRepository.findById(id).orElse(null);

    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(
            @PathVariable("student-name") String name) {
        return studentRepository.findAllByFirstNameContaining(name);

    }
}
