package com.example.springboot.cruddemo.service;

import com.example.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee e);
    void deleteById(int id);
}
