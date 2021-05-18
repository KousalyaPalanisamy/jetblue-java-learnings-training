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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collegeId == null) ? 0 : collegeId.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastModifiedByDate == null) ? 0 : lastModifiedByDate.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (collegeId == null) {
			if (other.collegeId != null)
				return false;
		} else if (!collegeId.equals(other.collegeId))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastModifiedByDate == null) {
			if (other.lastModifiedByDate != null)
				return false;
		} else if (!lastModifiedByDate.equals(other.lastModifiedByDate))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}
	
	
	
}
