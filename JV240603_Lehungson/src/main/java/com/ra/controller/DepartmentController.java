package com.ra.controller;

import com.ra.model.dto.ResponseDTO;
import com.ra.model.dto.department.DepartmentDTORequest;
import com.ra.model.dto.department.DepartmentDTOResponse;
import com.ra.model.dto.department.DepartmentUpdateDTORequest;
import com.ra.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public ResponseEntity<ResponseDTO<List<DepartmentDTOResponse>>>index(){
        List<DepartmentDTOResponse> dtoResponseList = departmentService.findAllDepartments();
        ResponseDTO<List<DepartmentDTOResponse>> responseDTO = new ResponseDTO<>(200, "Get department success", dtoResponseList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ResponseDTO<DepartmentDTOResponse>>createDepartment(@RequestBody DepartmentDTORequest departmentDTORequest){
        DepartmentDTOResponse departmentDTOResponse = departmentService.create(departmentDTORequest);
        ResponseDTO<DepartmentDTOResponse> responseDTO = new ResponseDTO<>(201, "Create department success", departmentDTOResponse);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<DepartmentDTOResponse>>findById(@PathVariable("id") Long id){
        DepartmentDTOResponse dtoResponse = departmentService.findDepartmentById(id);
        ResponseDTO<DepartmentDTOResponse> responseDTO = new ResponseDTO<>(200, "Get department by id " + id + "success", dtoResponse);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTOResponse> updateDepartment(@PathVariable Long id, @RequestBody DepartmentUpdateDTORequest departmentUpdateDTORequest){
        departmentUpdateDTORequest.setId(id);
        DepartmentDTOResponse dtoResponse = departmentService.create(departmentUpdateDTORequest);
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
