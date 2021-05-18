package com.learnJava.java8.model;

import java.time.Instant;
import java.util.function.Supplier;

public class SortWithComps implements Comparable<SortWithComps>
{
	String employeeName;
	int employeeID;
	String employeeDesignation;
	Instant date;

	Supplier<Instant> createdDateTime = () -> Instant.now();

	public SortWithComps()
	{
	}
	public SortWithComps(String employeeName) {
		this.employeeName = employeeName;
	}

	public SortWithComps(int empID, String empName, String empDesig)
	{
		this.employeeName = empName;
		this.employeeDesignation = empDesig;
		this.employeeID = empID;
		setDate(createdDateTime.get());
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}
	@Override
	public String toString()
	{
		return "[ Employee ID = "+employeeID+", Employee Name = "+employeeName+", Employee Designation = "+employeeDesignation+" createdDateTime = "+date+" ]";
	}

	@Override
	public int compareTo(SortWithComps compare) 
	{ 
		return this.employeeID-compare.getEmployeeID();
	}

	//	@Override
	//	public String toString() {
	//		return "SortWithComps [employeeName=" + employeeName + "]";
	//	}

}
