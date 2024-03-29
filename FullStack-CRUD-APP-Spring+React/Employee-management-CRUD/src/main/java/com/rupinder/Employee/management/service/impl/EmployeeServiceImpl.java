package com.rupinder.Employee.management.service.impl;

import com.rupinder.Employee.management.dto.EmployeeDto;
import com.rupinder.Employee.management.entity.Employee;
import com.rupinder.Employee.management.exception.ResourceNotFoundException;
import com.rupinder.Employee.management.mapper.EmployeeMapper;
import com.rupinder.Employee.management.repository.EmployeeRepository;
import com.rupinder.Employee.management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee savedEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given Id : "+id));
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .toList();
    }

    @Override
    public EmployeeDto deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with the id : "+id));
        employeeRepository.deleteById(id);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
