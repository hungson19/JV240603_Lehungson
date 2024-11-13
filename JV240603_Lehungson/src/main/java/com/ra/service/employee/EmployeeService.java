package com.ra.service.employee;

import com.ra.model.dto.employee.EmployeeDTORequest;
import com.ra.model.dto.employee.EmployeeDTOResponse;
import com.ra.model.dto.employee.EmployeeUpdateDTORequest;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTOResponse> findEmployeeAll();
    EmployeeDTOResponse create(EmployeeDTORequest employeeDTORequest);
    EmployeeDTOResponse findEmployeeById(String id);
    EmployeeDTOResponse create(EmployeeUpdateDTORequest employeeUpdateDTORequest);
    void deleteEmployeeById(String id);
}
