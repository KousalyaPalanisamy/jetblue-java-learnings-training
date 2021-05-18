package com.cosmos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactiveStudent")
public class StudentReactivePOSTPUTDELETEControllers 
{
	@Autowired
	private StudentReactiveServices studentReactiveService;

	@PostMapping
	public Mono<ResponseEntity<Student>> createStudent(@Valid @RequestBody Student student) {
		return studentReactiveService.createReactiveStudent(student);
	}

	@PutMapping("/{id}")
	public Mono updateStudent(@PathVariable String id, @RequestBody Student student) {
		return studentReactiveService.updateReactiveStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable(value = "id") String id) {
		return studentReactiveService.deleteReactiveStudent(id);
	}
}
