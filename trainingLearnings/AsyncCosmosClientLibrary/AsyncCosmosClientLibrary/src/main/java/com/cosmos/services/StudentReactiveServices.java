package com.cosmos.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.azure.cosmos.models.PartitionKey;
import com.cosmos.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentReactiveServices 
{

	public Flux<Student> listAllReactiveStudents();

	public List<Student> listStudentsOfTypeList();
	
	public Mono<ResponseEntity<Student>> getReactiveStudentById(String id);

	public Mono<ResponseEntity<Student>> createReactiveStudent(Student student);

	public Mono updateReactiveStudent(String id, Student student);

	public Mono<ResponseEntity<Void>> deleteReactiveStudent(String id);

	public Mono<ResponseEntity<Student>> listStudentByIdWithPartitionKey(String id, String partitionKey);

	public Flux<Student> listAllStudentsByPartitionKey(String partitionKey);

}
