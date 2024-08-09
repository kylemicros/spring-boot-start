package com.cayla.fondue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cayla.fondue.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
