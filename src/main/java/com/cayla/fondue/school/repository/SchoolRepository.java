package com.cayla.fondue.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cayla.fondue.school.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
