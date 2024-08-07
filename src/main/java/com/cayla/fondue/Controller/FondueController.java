package com.cayla.fondue.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.cayla.fondue.Entity.Student;
import com.cayla.fondue.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class FondueController {

    private final StudentRepository studentRepository;

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void delete(
            @RequestBody Long id) {
        studentRepository.deleteById(id);
    }

}
