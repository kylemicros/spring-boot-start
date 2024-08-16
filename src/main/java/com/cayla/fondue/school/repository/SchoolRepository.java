package com.cayla.fondue.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cayla.fondue.school.entity.School;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {
    List<School> findBySchoolName(String schoolName);
}
