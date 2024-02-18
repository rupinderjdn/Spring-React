package com.rupinder.Employee.management.repository;

import com.rupinder.Employee.management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
