package com.insignia.employeemanager.service;

import com.insignia.employeemanager.exception.UserNotFoundException;
import com.insignia.employeemanager.model.Employee;
import com.insignia.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo = new EmployeeRepo();

    public Employee addEmployee(Employee employee) {
        return employeeRepo.addEmployee(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.getEmployees();
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.saveEmployee(employee);
    }
}
