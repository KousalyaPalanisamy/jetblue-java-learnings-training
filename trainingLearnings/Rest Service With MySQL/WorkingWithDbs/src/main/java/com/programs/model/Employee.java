package com.programs.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@XmlRootElement(name="employee")
@Entity
@Table(name="details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	@Column(name="Empid")
	private int empId;
	@Column(name="Name")
	private String name;
	@Column(name="Designation")
	private String designation;
	@Column(name="Location")
	private String location;
	@Column(name="createdDateTime", updatable = false)
	private Instant createdDateTime;
	@Column(name="lastModifiedDateTime")
	private Instant lastModifiedDateTime;

	public Employee() {
	}

	public Employee(int empId, String name, String designation, String location) {
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.location = location;
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

	public void setEmpId(int Empid) {
		this.empId = Empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String Designation) {
		this.designation = Designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String Location) {
		this.location = Location;
	}

	public Instant getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Instant createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Instant getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(Instant lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	@Override
	public String toString() {
		return "EmpData [sno=" + sno + ", empId=" + empId + ", name=" + name + ", designation=" + designation
				+ ", location=" + location + ", createdDateTime=" + createdDateTime + ", lastModifiedDateTime="
				+ lastModifiedDateTime + "]";
	}

	
}
