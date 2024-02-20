package com.rupinder.Employee.management.service;

import com.rupinder.Employee.management.dto.EmployeeDto;
import com.rupinder.Employee.management.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto deleteEmployee(Long id);
}
