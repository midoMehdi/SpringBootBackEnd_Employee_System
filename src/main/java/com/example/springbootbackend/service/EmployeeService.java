package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee create_employee(Employee employee);
    ResponseEntity<Employee> getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
