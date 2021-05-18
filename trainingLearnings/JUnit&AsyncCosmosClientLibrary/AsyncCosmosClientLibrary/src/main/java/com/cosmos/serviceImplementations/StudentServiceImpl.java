package com.cosmos.serviceImplementations;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cosmos.model.Student;
import com.cosmos.services.StudentReactiveServices;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentReactiveServices {

	@Autowired
	private StudentGETServiceImpl studentGETService;
	@Autowired
	private StudentPUTPOSTDELETEServiceImpl studentPPDService;

	// List all students
	@Override
	public List<Student> listAllReactiveStudents() {
		return studentGETService.listAllReactiveStudents();//.collectList().block();
	}

	// Get Student BY Id
	@Override
	public Student getReactiveStudentById(String id) {
		return studentGETService.getReactiveStudentById(id);
	}

	// List all students by partitionKey
	@Override
	public List<Student> listAllStudentsByPartitionKey(String partitionKey) {
		return studentGETService.listAllStudentsByPartitionKey(partitionKey);
	}

	// Get Student By Id and Partition Key
	@Override
	public Student listStudentByIdWithPartitionKey(String id, String partitionKey) {
		return studentGETService.listStudentByIdWithPartitionKey(id, partitionKey);
	}

	// Create New Student
	@Override
	public Student createReactiveStudent(@Valid @RequestBody Student student) {
		return studentPPDService.createReactiveStudent(student);
	}

	// Update Student by id
	@Override
	@Transactional
	public Student updateReactiveStudentById(String id, Student student) {
		return studentPPDService.updateReactiveStudentById(id, student);
	}

	// delete student by Id
	@Override
	public void deleteReactiveStudentById(String id) {
		studentPPDService.deleteReactiveStudentById(id);
	}

	@Override
	public void deleteAllReactiveStudents() {
		studentPPDService.deleteAllReactiveStudents();
	}

//	@Override
//	public Flux<ResponseEntity<Student>> saveAllStudents(List<Student> studentList)
//	{
//		return studentPPDService.saveAllReactiveStudent(studentList);
//	}

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