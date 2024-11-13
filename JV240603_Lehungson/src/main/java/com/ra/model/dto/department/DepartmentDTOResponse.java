package com.ra.model.dto.department;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentDTOResponse {
    private Long id;
    private String name;
    private String description;
    private Boolean status;
}
