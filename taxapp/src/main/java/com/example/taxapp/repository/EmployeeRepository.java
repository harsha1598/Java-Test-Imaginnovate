package com.example.taxapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taxapp.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
    
}