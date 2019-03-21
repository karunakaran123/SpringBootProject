package com.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer empId;;
	private String empName;
	private Double empSal;
	private String empAddr;
	public Employee() {
		super();
	}
	
	public Employee(String empName, Double empSal, String empAddr) {
		super();
		this.empName = empName;
		this.empSal = empSal;
		this.empAddr = empAddr;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empAddr=" + empAddr
				+ "]";
	}
	
}
