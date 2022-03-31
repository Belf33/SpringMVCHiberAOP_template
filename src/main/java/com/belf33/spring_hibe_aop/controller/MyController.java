package com.belf33.spring_hibe_aop.controller;

import com.belf33.spring_hibe_aop.entity.Employee;
import com.belf33.spring_hibe_aop.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", employeeList);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {
//        Another way to delete!
//        String hql = "delete " + clazz.getName() + " where id = :id";
//        Query q = session.createQuery(hql).setParameter("id", id);
//        q.executeUpdate();
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
