package com.cosmos.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.azure.cosmos.models.PartitionKey;
import com.cosmos.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentReactiveServices 
{
	public List<Student> listAllReactiveStudents();
	
	public Student getReactiveStudentById(String id);

	public Student createReactiveStudent(Student student);

	public Student updateReactiveStudentById(String id, Student student);

	public void deleteReactiveStudentById(String id);

	public Student listStudentByIdWithPartitionKey(String id, String partitionKey);

	public List<Student> listAllStudentsByPartitionKey(String partitionKey);

	public void deleteAllReactiveStudents();
//
//	public Flux<ResponseEntity<Student>> saveAllStudents(List<Student> studentList);

}
