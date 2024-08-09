package com.cayla.fondue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cayla.fondue.Entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
