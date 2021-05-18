package com.cosmos.model;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "StudentInfo")
public class Student 
{
	@Id	
	private String id;
	@NotBlank(message = "Student Id cannot be blank")
	private String studentId;

	private String studentName;
	
	private String collegeId;

	@PartitionKey
	@NotBlank(message = "Course Id cannot be blank")
	private String courseId;
	
	@CreatedDate
    private OffsetDateTime createdDate;
	
	@LastModifiedDate
    private OffsetDateTime lastModifiedByDate;

	public Student() {}

	public Student(String enrollId, String studentId, String studentName, String collegeId, String courseId) {
		this.id = enrollId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.collegeId = collegeId;
		this.courseId = courseId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
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

	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public OffsetDateTime getLastModifiedByDate() {
		return lastModifiedByDate;
	}

	public void setLastModifiedByDate(OffsetDateTime lastModifiedByDate) {
		this.lastModifiedByDate = lastModifiedByDate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", studentName=" + studentName + ", collegeId="
				+ collegeId + ", courseId=" + courseId + ", createdDate=" + createdDate + ", lastModifiedByDate="
				+ lastModifiedByDate + "]";
	}
	
}
