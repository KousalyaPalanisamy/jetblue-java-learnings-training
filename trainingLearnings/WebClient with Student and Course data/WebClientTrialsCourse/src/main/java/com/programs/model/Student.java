package com.programs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="students")
@Entity
@Table(name="studentinfo")
public class Student 
{
	@Id
	@Column(name="enrollid")
	private String enrollId;
	
	@Column(name="studentid")
	private int studentId;
	
	@Column(name="studentname")
	private String studentName;
	
	@Column(name="collegeid")
	private String collegeId;
	
	@Column(name="courseid")
	private String courseId;

	public Student() {}

	public Student(String enrollId, int studentId, String studentName, String collegeId, String courseId) {
		this.enrollId = enrollId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.collegeId = collegeId;
		this.courseId = courseId;
	}

	public String getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(String enrollId) {
		this.enrollId = enrollId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "StudentData [enrollId=" + enrollId + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", collegeId=" + collegeId + ", courseId=" + courseId + "]";
	}
	
	
	
}
