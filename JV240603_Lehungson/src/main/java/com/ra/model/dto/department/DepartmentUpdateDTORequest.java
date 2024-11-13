package com.ra.model.dto.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentUpdateDTORequest {
    private Long id;
    private String name;
    private String description;
    private Boolean status;
}
