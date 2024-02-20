package com.rupinder.Employee.management.service.impl;

import com.rupinder.Employee.management.dto.EmployeeDto;
import com.rupinder.Employee.management.entity.Employee;
import com.rupinder.Employee.management.mapper.EmployeeMapper;
import com.rupinder.Employee.management.repository.EmployeeRepository;
import com.rupinder.Employee.management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmpployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmpployee);
    }
}
