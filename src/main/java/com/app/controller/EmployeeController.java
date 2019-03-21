package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Employee;
import com.app.service.IEmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@RequestMapping("/reg")
	public String showEmpReg(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "EmpReg";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveEmp(@ModelAttribute Employee employee ,Model model)
	{
		Integer empId=service.saveEmp(employee);
		model.addAttribute("employee", new Employee());
		model.addAttribute("msg","Employee "+empId+"  Registered successsfully!");
		return "EmpReg";
	}
	@RequestMapping("/all")
	public String getAll(Model model) {
		
		List<Employee> list=service.getAllEmp();
		model.addAttribute("list",list);
		return "EmpData";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmp(@PathVariable Integer id, Model model)
	{
		service.deleteEmp(id);
		List<Employee> list=service.getAllEmp();
		model.addAttribute("msg","Employee "+id+" Deleted");
		model.addAttribute("list",list);
		return "EmpData";
	}
	@RequestMapping("/update/{id}")
	public String updateEmpReg(@PathVariable Integer id,Model model)
	{
		Employee e=service.getOneEMp(id);
		model.addAttribute("employee",e);
		return "EmpReg";
	}
	@RequestMapping("/one/{id}")
	public String getOneEmployee(@PathVariable Integer id,Model model)
	{
		Employee emp=service.getOneEMp(id);
		model.addAttribute("employee",emp);
		return "OneEmp";
	}
	
}
