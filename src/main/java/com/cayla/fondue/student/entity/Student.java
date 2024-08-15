package com.cayla.fondue.student.entity;

import com.cayla.fondue.school.entity.School;
import com.cayla.fondue.studentprofile.entity.StudentProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL) // CascadeType.ALL means that all changes to the student
                                                               // object will be saved or deleted
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference // This is used to serialize the school object
    private School school; // The student entity does not need to serialize the school object
}
