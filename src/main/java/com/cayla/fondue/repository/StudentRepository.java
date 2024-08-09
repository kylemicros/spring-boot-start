package com.cayla.fondue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cayla.fondue.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByFirstNameContaining(String firstName);
}
