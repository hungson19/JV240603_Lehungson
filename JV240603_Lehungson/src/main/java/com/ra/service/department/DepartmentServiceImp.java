package com.ra.service.department;

import com.ra.model.dto.department.DepartmentDTORequest;
import com.ra.model.dto.department.DepartmentDTOResponse;
import com.ra.model.dto.department.DepartmentUpdateDTORequest;
import com.ra.model.entity.Department;
import com.ra.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentDTOResponse> findAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTOResponse> departmentDTOResponses = new ArrayList<>();
        for (Department department : departments) {
            DepartmentDTOResponse DTOResponse = DepartmentDTOResponse.builder()
                    .id(department.getId())
                    .name(department.getName())
                    .description(department.getDescription())
                    .status(department.getStatus())
                    .build();
            departmentDTOResponses.add(DTOResponse);
        }
        return departmentDTOResponses;
    }

    @Override
    public DepartmentDTOResponse create(DepartmentDTORequest departmentDTORequest) {
        Department department = Department.builder()
                .name(departmentDTORequest.getName())
                .description(departmentDTORequest.getDescription())
                .status(departmentDTORequest.getStatus())
                .build();
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentDTOResponse.builder()
                .id(savedDepartment.getId())
                .name(savedDepartment.getName())
                .description(savedDepartment.getDescription())
                .status(savedDepartment.getStatus())
                .build();
    }

    @Override
    public DepartmentDTOResponse findDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return DepartmentDTOResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .status(department.getStatus())
                .build();
    }

    @Override
    public DepartmentDTOResponse create(DepartmentUpdateDTORequest departmentUpdateDTORequest) {
        Department department = Department.builder()
                .id(departmentUpdateDTORequest.getId())
                .name(departmentUpdateDTORequest.getName())
                .description(departmentUpdateDTORequest.getDescription())
                .status(departmentUpdateDTORequest.getStatus())
                .build();
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentDTOResponse.builder()
                .id(savedDepartment.getId())
                .name(savedDepartment.getName())
                .description(savedDepartment.getDescription())
                .status(savedDepartment.getStatus())
                .build();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }
}
