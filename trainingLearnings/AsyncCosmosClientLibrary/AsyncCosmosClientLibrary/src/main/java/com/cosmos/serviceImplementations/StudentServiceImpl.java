package com.cosmos.serviceImplementations;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.azure.cosmos.models.PartitionKey;
import com.cosmos.exceptions.EntityNotFoundException;
import com.cosmos.model.Student;
import com.cosmos.repository.StudentReactiveCosmosRepository;
import com.cosmos.services.StudentReactiveServices;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentReactiveServices {

	@Autowired
	private StudentReactiveCosmosRepository studentReactiveRepo;

	// List all students
	@Override
	public Flux<Student> listAllReactiveStudents() {

		return studentReactiveRepo.findAll().switchIfEmpty(Flux.error(new EntityNotFoundException("records")));
	}

	// list all students and return them in list type
	@Override
	public List<Student> listStudentsOfTypeList() {
		return studentReactiveRepo.findAll().collectList().block();
	}

	// Get Student BY Id
	@Override
	public Mono<ResponseEntity<Student>> getReactiveStudentById(String id) {
		return studentReactiveRepo.findById(id).map(student -> ResponseEntity.ok(student))
				.switchIfEmpty(Mono.error(new EntityNotFoundException("ID", id)));
	}

	// Create New Student
	@Override
	public Mono<ResponseEntity<Student>> createReactiveStudent(@Valid @RequestBody Student student) {
		return studentReactiveRepo.save(student).map(newStudent -> ResponseEntity.ok(newStudent))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	// Update Student by id
	@Override
	@Transactional
	public Mono updateReactiveStudent(String id, Student student) {
		return studentReactiveRepo.save(student);
	}

	// delete student by Id
	@Override
	public Mono<ResponseEntity<Void>> deleteReactiveStudent(String id) {
		return studentReactiveRepo.findById(id)
				.flatMap(deleteStudent -> studentReactiveRepo.delete(deleteStudent)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
				.switchIfEmpty(Mono.error(new EntityNotFoundException("ID", id)));
	}

	// List all students by partitionKey
	@Override
	public Flux<Student> listAllStudentsByPartitionKey(String partitionKey) {
		return studentReactiveRepo.findAll(new PartitionKey(partitionKey));
	}

	// Get Student By Id and Partition Key
	@Override
	public Mono<ResponseEntity<Student>> listStudentByIdWithPartitionKey(String id, String partitionKey) {
		return studentReactiveRepo.findById(id, new PartitionKey(partitionKey))
				.map(student -> ResponseEntity.ok(student))
				.switchIfEmpty(Mono.error(new EntityNotFoundException("ID", id)));
	}

}


























/*
 * update code which is not needed
 * 
 * return studentReactiveRepo.findById(id).flatMap(studentUpdate -> {
 * studentUpdate.setId(student.getId());
 * studentUpdate.setStudentId(student.getStudentId());
 * studentUpdate.setStudentName(student.getStudentName());
 * studentUpdate.setCollegeId(student.getCollegeId());
 * studentUpdate.setCourseId(student.getCourseId()); return
 * studentReactiveRepo.save(student); }).map(updatedStudent ->
 * ResponseEntity.ok(updatedStudent)) .defaultIfEmpty(new
 * ResponseEntity<>(HttpStatus.NOT_FOUND));
 * 
 * 
 * // studentReactiveRepo.findById(student.getId()) // .then(return
 * Mono.just(studentReactiveRepo.save(student).map(newStudent ->
 * ResponseEntity.ok(newStudent)) //
 * .defaultIfEmpty(ResponseEntity.notFound().build());) //
 * .switchIfEmpty(Mono.error(new EntityAlreadyExixtsException("ID",
 * student.getId())));
 */