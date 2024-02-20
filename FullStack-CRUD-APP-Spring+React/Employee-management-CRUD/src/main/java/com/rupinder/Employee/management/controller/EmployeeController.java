package com.rupinder.Employee.management.controller;

import com.rupinder.Employee.management.dto.EmployeeDto;
import com.rupinder.Employee.management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id){
        HttpStatus httpStatus = HttpStatus.OK;
        EmployeeDto savedEmployee = employeeService.getEmployee(id);
        if(savedEmployee == null)httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(savedEmployee,httpStatus);
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto){
        HttpStatus httpStatus = HttpStatus.OK;
        EmployeeDto savedEmployee = employeeService.updateEmployee(employeeDto);
        if(savedEmployee == null)httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(savedEmployee,httpStatus);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") Long id){
        EmployeeDto employeeList = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
}
