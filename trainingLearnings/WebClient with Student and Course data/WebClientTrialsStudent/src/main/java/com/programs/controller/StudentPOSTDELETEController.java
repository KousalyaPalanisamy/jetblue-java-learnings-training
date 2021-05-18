package com.programs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programs.model.Student;
import com.programs.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentPOSTDELETEController 
{
	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	@DeleteMapping("/{enrollId}")
	public void deleteStudent(@PathVariable("enrollId") String enrollId) {
		studentService.deleteStudent(enrollId);
	}
}
