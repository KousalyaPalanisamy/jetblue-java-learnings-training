package com.cosmos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmos.model.Student;
import com.cosmos.services.StudentReactiveServices;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactiveStudent")
public class StudentReactiveGETControllers {
	@Autowired
	private StudentReactiveServices studentReactiveService;

	@GetMapping
	public Flux<Student> listAllStudents() {
		return studentReactiveService.listAllReactiveStudents();
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Student>> getStudentById(@PathVariable String id) {
		return studentReactiveService.getReactiveStudentById(id);
	}

	@GetMapping("/partitionkey/{partitionKey}")
	public Flux<Student> listAllStudentsByPartitionKey(@PathVariable String partitionKey) {
		return studentReactiveService.listAllStudentsByPartitionKey(partitionKey);
	}
	
	@GetMapping("/{id}/partitionKey/{partitionKey}")
	public Mono<ResponseEntity<Student>> getStudentByIdWithPartitionKey(@PathVariable String id, @PathVariable String partitionKey)
	{
		return studentReactiveService.listStudentByIdWithPartitionKey(id, partitionKey);
	}
	
}






















//@GetMapping
//public List<Student> listAllStudentsofTypeList() {
//	return studentReactiveService.listStudentsOfTypeList();
//}
