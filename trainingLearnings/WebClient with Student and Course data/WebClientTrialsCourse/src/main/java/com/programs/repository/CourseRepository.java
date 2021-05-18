package com.programs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.programs.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> 
{
	/*
	@Query("Select c.courseId, c.courseName, c.durationInMonths, s.studentId, s.studentName, s.courseId from Course c, Student s where c.courseId = :courseId")
	Optional<Course> findById(String courseId);
	*/
}
