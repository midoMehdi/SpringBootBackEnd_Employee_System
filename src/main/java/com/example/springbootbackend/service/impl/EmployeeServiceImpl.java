package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Employee;
import com.example.springbootbackend.repository.EmployeeRepository;
import com.example.springbootbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee create_employee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Long id) {
        Employee employee =  this.employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not found"));
        return ResponseEntity.ok(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee =  this.employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not found"));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmailId(employee.getEmailId());
        return this.employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
