package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeService {
	
	public Integer saveEmp(Employee employee);
	public void deleteEmp(Integer empId);
	public Employee getOneEMp(Integer empId);
	public List<Employee> getAllEmp();
}
