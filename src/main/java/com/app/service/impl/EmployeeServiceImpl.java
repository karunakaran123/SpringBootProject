package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repo.EmployeeRepo;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public Integer saveEmp(Employee employee) {
	     employee=repo.save(employee);
	     return employee.getEmpId();
	}

	
	  @Override
	  @CacheEvict(value="EmpCache",key="#empId")
	  public void deleteEmp(Integer empId)
	  { repo.deleteById(empId);
	  
	  }
	  
	  @Override 
	  @Cacheable(value="EmpCache",key="#empId")
	  public Employee getOneEMp(Integer empId) 
	  { 
		  Optional<Employee>  emp= repo.findById(empId);
		  if(emp.isPresent())
			 return emp.get();
		  else
			  return new Employee();
	  
	  }
	  
	  @Override public List<Employee> getAllEmp() 
	  { // TODO Auto-generated method
	   return repo.findAll(); }
	 

}
