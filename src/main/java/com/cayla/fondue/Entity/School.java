package com.cayla.fondue.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "school")
@Data
public class School {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> students;
}
