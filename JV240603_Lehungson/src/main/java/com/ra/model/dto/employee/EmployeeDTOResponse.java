package com.ra.model.dto.employee;

import com.ra.model.entity.Department;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDTOResponse {
    private String id;
    private String name;
    private Date birthOfDate;
    private Boolean sex;
    private String address;
    private String email;
    private String phone;
    private String avatar;
    private Boolean status;
    private Department department;
}
