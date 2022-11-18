package com.raflprojects.employeemanager.service;

import com.raflprojects.employeemanager.exception.UserNotFoundException.UserNotFoundException;
import com.raflprojects.employeemanager.model.Employee;
import com.raflprojects.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    //injecting the employeeRepo into employeeService, this way whenever this employeeService is constructed, I'll have the employee repo inside it to do whatever I want to.
    private final EmployeeRepo employeeRepo;

    //To make the injection work I need to add @Autowired to the constructor.
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    //CRUD OPERATIONS

    //create
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    //read
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    //update
    public Employee updateEmployee (Employee employee) {
        return employeeRepo.save(employee);
    }

    //delete
    public void deleteEmployee (Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById (Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow( () -> new UserNotFoundException("User by id " + id + "was not found."));
    }
}
