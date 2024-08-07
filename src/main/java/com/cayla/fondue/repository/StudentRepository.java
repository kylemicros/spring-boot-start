package com.cayla.fondue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cayla.fondue.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
