package com.cayla.fondue.school.entity;

import java.util.List;

import com.cayla.fondue.student.entity.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "school")
@Data
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_id_seq")
    private Long id;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> students;

    public School(String schoolName, String address) {
        this.schoolName = schoolName;
        this.address = address;
    }
}
