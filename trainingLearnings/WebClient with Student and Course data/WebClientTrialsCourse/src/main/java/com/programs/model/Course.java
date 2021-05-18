package com.programs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="courses")
@Entity
@Table(name="courseinfo")
public class Course 
{
	@Id
	@Column(name="courseid")
	private String courseId;
	
	@Column(name="coursename")
	private String courseName;
	
	@Column(name="durationinmonths")
	private int durationInMonths;
	
	public Course() {}

	public Course(String courseId, String courseName, int durationInMonths) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.durationInMonths = durationInMonths;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", durationInMonths=" + durationInMonths
				+ "]";
	}
	
	
}
