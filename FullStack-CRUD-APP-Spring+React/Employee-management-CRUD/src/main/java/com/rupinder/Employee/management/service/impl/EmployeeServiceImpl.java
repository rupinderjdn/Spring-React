package com.rupinder.Employee.management.service.impl;

import com.rupinder.Employee.management.dto.EmployeeDto;
import com.rupinder.Employee.management.entity.Employee;
import com.rupinder.Employee.management.mapper.EmployeeMapper;
import com.rupinder.Employee.management.repository.EmployeeRepository;
import com.rupinder.Employee.management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDto.getId());
        Employee savedEmployee = optionalEmployee.orElse(null);
        if(savedEmployee!=null){
            System.out.println("Employee found with ID ==> "+employeeDto.getId());
            savedEmployee = EmployeeMapper.mapToEmployee(employeeDto);
            employeeRepository.save(savedEmployee);
            return EmployeeMapper.mapToEmployeeDto(savedEmployee);
        }
        return null;
    }
}
