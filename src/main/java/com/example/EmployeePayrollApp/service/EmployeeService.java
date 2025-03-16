package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.customExceptions.EmployeeNotFoundException;
import com.example.EmployeePayrollApp.model.Employee;
import com.example.EmployeePayrollApp.repository.EmployeeRepository;
import com.example.EmployeePayrollApp.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return Optional.ofNullable(employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id))); // Throw custom exception
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(employeeDTO.getDepartment());
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> updateEmployee(Long id, EmployeeDTO updatedEmployeeDTO) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(updatedEmployeeDTO.getName());
            employee.setSalary(updatedEmployeeDTO.getSalary());
            employee.setDepartment(updatedEmployeeDTO.getDepartment());
            employeeRepository.save(employee);
            return Optional.of(employee);
        } else {
            throw new EmployeeNotFoundException(id);  // Throw exception if employee not found
        }
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);  // Throw exception if employee not found
        }
        employeeRepository.deleteById(id);
        return true;
    }
}