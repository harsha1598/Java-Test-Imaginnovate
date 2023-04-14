package com.example.taxapp.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxapp.Model.Employee;
import com.example.taxapp.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{
    private EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }
    
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }
    
    
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }
    
    @PostMapping("/employee/tax")
    public Long calculateTax(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);
        Long tax_amt = employeeService.calcTax(theEmployee);
        return tax_amt;
    }
}