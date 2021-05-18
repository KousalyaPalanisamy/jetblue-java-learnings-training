package com.cosmos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<List<Student>> listAllStudents() {
		return new ResponseEntity<>(studentReactiveService.listAllReactiveStudents(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable String id) {
		return new ResponseEntity<>(studentReactiveService.getReactiveStudentById(id), HttpStatus.OK);
	}

	@GetMapping("/partitionkey/{partitionKey}")
	public ResponseEntity<List<Student>> listAllStudentsByPartitionKey(@PathVariable String partitionKey) {
		return new ResponseEntity<>(studentReactiveService.listAllStudentsByPartitionKey(partitionKey), HttpStatus.OK);
	}

	@GetMapping("/{id}/partitionKey/{partitionKey}")
	public ResponseEntity<Student> getStudentByIdWithPartitionKey(@PathVariable String id,
			@PathVariable String partitionKey) {
		return new ResponseEntity<>(studentReactiveService.listStudentByIdWithPartitionKey(id, partitionKey),
				HttpStatus.OK);
	}

}
























//@GetMapping
//public List<Student> listAllStudentsofTypeList() {
//	return studentReactiveService.listStudentsOfTypeList();
//}
