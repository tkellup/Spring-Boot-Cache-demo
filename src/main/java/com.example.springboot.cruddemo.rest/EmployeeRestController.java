package com.example.springboot.cruddemo.rest;

import com.example.springboot.cruddemo.entity.Employee;
import com.example.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    //add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee not found.");
        }
        return employee;
    }

    //add mapping for POST /employees--add new Employee
    @PostMapping
    public Employee saveEmployee(Employee e) {
        //also just in case they pass an id in JSON...
        //set id to 0; this will force a save of new item
        //instead of update
        e.setId(0);
        employeeService.save(e);
        return e;
    }

    //add mapping for PUT /employees--update Employee
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee e) {
        employeeService.save(e);
        return e;
    }

    //delete mapping for DELETE /employees/{employeeId}
    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable("employeeId") int id) {
        //find employee first
        Employee e = employeeService.findById(id);

        if (e == null) {
            throw new RuntimeException("Employee not found - " + id);
        }
        employeeService.deleteById(id);
        return "Deleted employee id - " + id;
    }
}
