package com.ra.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id", length = 5)
    private String id;
    @Column(name = "emp_name", length = 100, nullable = false)
    private String name;
    @Column(name = "emp_BirthOfDate", nullable = false)
    private Date birthOfDate;
    @Column(name = "emp_sex", nullable = false)
    private Boolean sex;
    @Column(name = "emp_address", nullable = false)
    private String address;
    @Column(name = "emp_email", length = 200, nullable = false, unique = true)
    private String email;
    @Column(name = "emp_phone", length = 11, nullable = false, unique = true)
    private String phone;
    @Column(name = "emp_avatar")
    private String avatar;
    @Column(name = "emp_status", columnDefinition = "BIT DEFAULT 1")
    private Boolean status = true;
    @ManyToOne
    @JoinColumn(name = "department", referencedColumnName = "dept_id")
    private Department department;
}
