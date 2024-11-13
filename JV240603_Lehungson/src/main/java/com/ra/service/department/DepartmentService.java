package com.ra.service.department;

import com.ra.model.dto.department.DepartmentDTORequest;
import com.ra.model.dto.department.DepartmentDTOResponse;
import com.ra.model.dto.department.DepartmentUpdateDTORequest;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDTOResponse> findAllDepartments();
    DepartmentDTOResponse create(DepartmentDTORequest departmentDTORequest);
    DepartmentDTOResponse findDepartmentById(Long id);
    DepartmentDTOResponse create(DepartmentUpdateDTORequest departmentUpdateDTORequest);
    void deleteDepartmentById(Long id);
}
