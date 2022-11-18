package com.raflprojects.employeemanager.repo;

import com.raflprojects.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    //by only using the method name, spring is able to understand what I want to do with this method.
    void deleteEmployeeById(Long id);

    //Optional is being used here in case there is no employee with the requested Id
    Optional<Employee> findEmployeeById(Long id);
}
