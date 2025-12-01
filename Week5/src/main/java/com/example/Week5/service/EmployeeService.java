package com.example.Week5.service;

import com.example.Week5.model.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(int id, Employee employee);
    String deleteEmployee(int id);
}
