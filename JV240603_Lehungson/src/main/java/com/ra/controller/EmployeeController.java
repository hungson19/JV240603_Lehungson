package com.ra.controller;

import com.ra.model.dto.ResponseDTO;
import com.ra.model.dto.department.DepartmentDTORequest;
import com.ra.model.dto.department.DepartmentDTOResponse;
import com.ra.model.dto.department.DepartmentUpdateDTORequest;
import com.ra.model.dto.employee.EmployeeDTORequest;
import com.ra.model.dto.employee.EmployeeDTOResponse;
import com.ra.model.dto.employee.EmployeeUpdateDTORequest;
import com.ra.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public ResponseEntity<ResponseDTO<List<EmployeeDTOResponse>>> index(){
        List<EmployeeDTOResponse> dtoResponseList = employeeService.findEmployeeAll();
        ResponseDTO<List<EmployeeDTOResponse>> responseDTO = new ResponseDTO<>(200, "Get employee success", dtoResponseList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ResponseDTO<EmployeeDTOResponse>>createEmployee(@RequestBody EmployeeDTORequest employeeDTORequest){
        EmployeeDTOResponse employeeDTOResponse = employeeService.create(employeeDTORequest);
        ResponseDTO<EmployeeDTOResponse> responseDTO = new ResponseDTO<>(201, "Create employee success", employeeDTOResponse);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<EmployeeDTOResponse>>findById(@PathVariable("id") String id){
        EmployeeDTOResponse dtoResponse = employeeService.findEmployeeById(id);
        ResponseDTO<EmployeeDTOResponse> responseDTO = new ResponseDTO<>(200, "Get employee by id " + id + "success", dtoResponse);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTOResponse> updateEmployee(@PathVariable String id, @RequestBody EmployeeUpdateDTORequest employeeUpdateDTORequest){
        employeeUpdateDTORequest.setId(id);
        EmployeeDTOResponse dtoResponse = employeeService.create(employeeUpdateDTORequest);
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
