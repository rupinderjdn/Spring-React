package com.rupinder.Employee.management.service;

import com.rupinder.Employee.management.dto.EmployeeDto;
import com.rupinder.Employee.management.entity.Employee;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
}
