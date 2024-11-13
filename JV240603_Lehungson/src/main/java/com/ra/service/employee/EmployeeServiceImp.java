package com.ra.service.employee;

import com.ra.model.dto.employee.EmployeeDTORequest;
import com.ra.model.dto.employee.EmployeeDTOResponse;
import com.ra.model.dto.employee.EmployeeUpdateDTORequest;
import com.ra.model.entity.Employee;
import com.ra.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTOResponse> findEmployeeAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTOResponse> employeeDTOResponses = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTOResponse employeeDTOResponse = EmployeeDTOResponse.builder()
                    .id(employee.getId())
                    .name(employee.getName())
                    .birthOfDate(employee.getBirthOfDate())
                    .sex(employee.getSex())
                    .address(employee.getAddress())
                    .email(employee.getEmail())
                    .phone(employee.getPhone())
                    .avatar(employee.getAvatar())
                    .status(employee.getStatus())
                    .build();
            employeeDTOResponses.add(employeeDTOResponse);
        }
        return employeeDTOResponses;
    }

    @Override
    public EmployeeDTOResponse create(EmployeeDTORequest employeeDTORequest) {
        Employee employee = Employee.builder()
                .id(employeeDTORequest.getId())
                .name(employeeDTORequest.getName())
                .birthOfDate(employeeDTORequest.getBirthOfDate())
                .sex(employeeDTORequest.getSex())
                .address(employeeDTORequest.getAddress())
                .email(employeeDTORequest.getEmail())
                .phone(employeeDTORequest.getPhone())
                .avatar(employeeDTORequest.getAvatar())
                .status(employeeDTORequest.getStatus())
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeDTOResponse.builder()
                .id(savedEmployee.getId())
                .name(savedEmployee.getName())
                .birthOfDate(savedEmployee.getBirthOfDate())
                .sex(savedEmployee.getSex())
                .address(savedEmployee.getAddress())
                .email(savedEmployee.getEmail())
                .phone(savedEmployee.getPhone())
                .avatar(savedEmployee.getAvatar())
                .status(savedEmployee.getStatus())
                .build();
    }

    @Override
    public EmployeeDTOResponse findEmployeeById(String id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return EmployeeDTOResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .birthOfDate(employee.getBirthOfDate())
                .sex(employee.getSex())
                .address(employee.getAddress())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .avatar(employee.getAvatar())
                .status(employee.getStatus())
                .build();
    }

    @Override
    public EmployeeDTOResponse create(EmployeeUpdateDTORequest employeeUpdateDTORequest) {
        Employee employee = Employee.builder()
                .id(employeeUpdateDTORequest.getId())
                .name(employeeUpdateDTORequest.getName())
                .birthOfDate(employeeUpdateDTORequest.getBirthOfDate())
                .sex(employeeUpdateDTORequest.getSex())
                .address(employeeUpdateDTORequest.getAddress())
                .email(employeeUpdateDTORequest.getEmail())
                .phone(employeeUpdateDTORequest.getPhone())
                .avatar(employeeUpdateDTORequest.getAvatar())
                .status(employeeUpdateDTORequest.getStatus())
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeDTOResponse.builder()
                .id(savedEmployee.getId())
                .name(savedEmployee.getName())
                .birthOfDate(savedEmployee.getBirthOfDate())
                .sex(savedEmployee.getSex())
                .address(savedEmployee.getAddress())
                .email(savedEmployee.getEmail())
                .phone(savedEmployee.getPhone())
                .avatar(savedEmployee.getAvatar())
                .status(savedEmployee.getStatus())
                .build();
    }

    @Override
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }
}
