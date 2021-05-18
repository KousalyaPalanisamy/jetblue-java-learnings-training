package com.programs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.programs.model.Course;
import com.programs.model.Student;
import com.programs.service.CourseService;

@RestController
@RequestMapping("/studentCourses")
public class CourseController 
{	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> listAllCourses()
	{
		return new ResponseEntity<>(courseService.listAllCourses(), HttpStatus.OK);
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable("courseId")String courseId)
	{
		return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
	}
	
	@GetMapping("/{studentId}/courses")
	public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable("studentId")int studentId)
	{
		return new ResponseEntity<>(courseService.getCoursesByStudentId(studentId), HttpStatus.OK);
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> saveStudent(@RequestBody Course course)
	{
		return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
	}
	
}




/*
students/studentId/
*/