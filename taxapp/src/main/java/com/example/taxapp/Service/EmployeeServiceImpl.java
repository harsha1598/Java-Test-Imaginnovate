package com.example.taxapp.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxapp.Model.Employee;
import com.example.taxapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository)
    {
        employeeRepository = theEmployeeRepository;
    }
    
    @Override
    public List<Employee> findAll() 
    {
        return employeeRepository.findAll();
    }

    

    @Override
    public void save(Employee theEmployee) 
    {
        employeeRepository.save(theEmployee);
    }

    @Override
    public Long calcTax(Employee theEmployee) 
    {
        
        
        //get the month in which the employee joined
        int month = theEmployee.getDOJ().getMonthValue();
        
        //get the day employee joined
        int days  = theEmployee.getDOJ().getDayOfMonth();
        
        int arr[] = {3,2,1,12,11,10,9,8,7,6,5,4};
        
        Long salary = theEmployee.getSalary()*findIndex(arr,month);
        
        //set the days as 30 due to timne constraint can use calender to d=this
        salary += theEmployee.getSalary()*(days/30);
        
        Long tax = (long) 0;
        if(salary < 250000) {
        	return tax;
        }
        else if (salary > 250000 && salary<=500000) {
        	return (long) (theEmployee.getSalary()-250000 * 0.05); 
        }
        else if (salary > 500000 && salary<=1000000) {
        	return (long) (250000*0.05  + (theEmployee.getSalary()-500000 * 0.10)); 
        }
        else if (salary > 1000000 && salary<=2500000) {
        	return (long) (250000*0.05 + 500000 *0.10 + (theEmployee.getSalary()-1000000 * 0.20)); 
        }
        else if (salary >2500000)
        {
        
        	return (long) ((250000*0.05 + 500000 *0.10 + (theEmployee.getSalary()-1000000 * 0.20))*1.02); 
        
        }   
        return tax;
    }
    
    public static int findIndex(int arr[], int t)
    {
  
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
}