package com.cayla.fondue.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.cayla.fondue.Entity.Student;
import com.cayla.fondue.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class FondueController {

    private final StudentRepository studentRepository;

    // @GetMapping("/students")
    // public List<Student> getAllStudents() {
    // return studentRepository.findAll();
    // }

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

    @GetMapping("/students/{id}")
    public Student getStudentById(
            @PathVariable("id") Long id) {
        return studentRepository.findById(id).orElse(null);

    }

    @PostMapping("/students/{id}")
    public Student updateStudent(
            @PathVariable("id") Long id,
            @RequestBody Student student) {
        return studentRepository.save(student);
    }

}
