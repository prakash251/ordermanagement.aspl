package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee 
{
	@Id
	long employeeId;
	String employeeName;
	String EmployeeTeam;
	String email;
	String password;
	public Employee()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(long employeeId, String employeeName, String employeeTeam, String email, String password) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		EmployeeTeam = employeeTeam;
		this.email =email;
		this.password = password;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeTeam() {
		return EmployeeTeam;
	}
	public void setEmployeeTeam(String employeeTeam) {
		EmployeeTeam = employeeTeam;
	}
	public String getEmail() {
		return email;
	}
	public void setEmployeeEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", EmployeeTeam="
				+ EmployeeTeam + ", employeeEmail=" + email + ", password=" + password + "]";
	}
	
	
	

}
