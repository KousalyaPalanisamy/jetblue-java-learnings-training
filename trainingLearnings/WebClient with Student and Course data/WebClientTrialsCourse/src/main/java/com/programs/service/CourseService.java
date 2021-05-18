package com.programs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.programs.model.Course;
import com.programs.model.Student;
import com.programs.repository.CourseRepository;

@Service
@Transactional
public class CourseService 
{
	@Autowired
	private WebClient.Builder webclient;
	
	@Autowired
	private CourseRepository courseRepo;
	
	public List<Course> listAllCourses()
	{
		return courseRepo.findAll();
	}
	
	public List<Course> getCoursesByStudentId(int studentId)
	{		
		List<Course> selectedStudentCourses = new ArrayList<>();
		webclientGetStudentById(studentId).forEach(student -> selectedStudentCourses.add(this.getCourseById(student.getCourseId())));
		return selectedStudentCourses;
	}
	
	public Course getCourseById(String courseId)
	{
		return courseRepo.findById(courseId).orElseThrow(() -> new IllegalArgumentException("No Course found for courseId "+courseId ));
	}
	
	public List<Student> webclientGetStudentById(int studentId)
	{
		return webclient.baseUrl("http://localhost:8091/students").build()
																.get()
																.uri(uriBuilder -> uriBuilder
																	    .path("/studentId/"+studentId)
																	    .build())
																.retrieve()
																.bodyToFlux(Student.class)
																.collectList()
																.block();
	}

	public Course saveCourse(Course course) 
	{	
		return courseRepo.save(course);
	}
}
