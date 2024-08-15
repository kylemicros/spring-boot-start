package com.cayla.fondue.studentprofile.entity;

import com.cayla.fondue.student.entity.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student_profile")
@Data
public class StudentProfile {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "bio_data")
    private String bio;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
