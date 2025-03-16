package com.example.EmployeePayrollApp.interfaces;

import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Employee createEmployee(EmployeeDTO employeeDTO);
    Optional<Employee> updateEmployee(Long id, EmployeeDTO updatedEmployeeDTO);
    boolean deleteEmployee(Long id);
}
