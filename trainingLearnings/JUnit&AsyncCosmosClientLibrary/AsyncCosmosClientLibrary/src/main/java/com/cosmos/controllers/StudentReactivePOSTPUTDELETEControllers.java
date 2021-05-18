package com.cosmos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmos.model.Student;
import com.cosmos.services.StudentReactiveServices;

@RestController
@RequestMapping("/reactiveStudent")
public class StudentReactivePOSTPUTDELETEControllers 
{
	@Autowired
	private StudentReactiveServices studentReactiveService;

	@PostMapping
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
		return new ResponseEntity<>(studentReactiveService.createReactiveStudent(student), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
		return new ResponseEntity<>(studentReactiveService.updateReactiveStudentById(id, student), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") String id) {
		studentReactiveService.deleteReactiveStudentById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
//	@PostMapping("/saveAll")
//	public Flux<ResponseEntity<Student>> saveAllStudents(@RequestBody List<Student> studentList)
//	{
//		return studentReactiveService.saveAllStudents(studentList);
//	}
	
//	@DeleteMapping("/deleteAll")
//	public ResponseEntity<Void> deleteAllStudents()
//	{
//		studentReactiveService.deleteAllReactiveStudents();
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
}
