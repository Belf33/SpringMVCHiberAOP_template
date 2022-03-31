package com.belf33.spring_hibe_aop.service;

import com.belf33.spring_hibe_aop.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
