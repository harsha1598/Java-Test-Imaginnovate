package com.example.taxapp.Service;

import java.util.List;

import com.example.taxapp.Model.Employee;

public interface EmployeeService 
{
    public List<Employee> findAll();
    
    public void save(Employee theEmployee);
    
    public Long calcTax(Employee theEmployee);
}