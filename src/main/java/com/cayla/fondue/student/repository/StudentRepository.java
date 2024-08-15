package com.cayla.fondue.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cayla.fondue.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByFirstNameContaining(String firstName);
}
