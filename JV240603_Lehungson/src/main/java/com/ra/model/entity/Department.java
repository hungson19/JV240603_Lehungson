package com.ra.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long id;
    @Column(name = "dept_name",length = 100, nullable = false, unique = true)
    private String name;
    @Column(name = "dept_description")
    private String description;
    @Column(name = "dept_status", columnDefinition = "BIT DEFAULT 1")
    private Boolean status = true;
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}
