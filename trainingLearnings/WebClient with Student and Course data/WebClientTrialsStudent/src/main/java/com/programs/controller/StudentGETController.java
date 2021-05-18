package com.programs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programs.model.Student;
import com.programs.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentGETController 
{
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> listAllStudents()
	{
		return new ResponseEntity<>(studentService.listAllStudents(), HttpStatus.OK);
	}
	
	@GetMapping("/{enrollId}")
	public ResponseEntity<Student> getStudentByEnrollId(@PathVariable("enrollId")String enrollId)
	{
		return new ResponseEntity<>(studentService.getStudentByEnrollId(enrollId), HttpStatus.OK);
	}
	
	@GetMapping("/studentId/{studentId}")
	public ResponseEntity<List<Student>> getStudentByStudentId(@PathVariable("studentId")int studentId)
	{
		return new ResponseEntity<>(studentService.getStudentByStudentId(studentId), HttpStatus.OK);
	}
		
}
