package com.programs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employeeQualification")
@Entity
@Table(name="qualification")
public class EmployeeQualification 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	@Column(name="Empid")
	private int empId;
	@Column(name="Name")
	private String name;
	@Column(name="Designation")
	private String designation;
	@Column(name="Qualification")
	private String qualification;
	
	public EmployeeQualification() 
	{
		
	}
	
	public EmployeeQualification(int empId, String name, String designation, String qualification) 
	{
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.qualification = qualification;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	
}
