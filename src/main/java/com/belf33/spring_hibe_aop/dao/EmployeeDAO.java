package com.belf33.spring_hibe_aop.dao;

import com.belf33.spring_hibe_aop.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();

    void addEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int employee);
}
