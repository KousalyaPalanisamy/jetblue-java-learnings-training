package com.cosmos.serviceImplementations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cosmos.exceptions.EntityNotFoundException;
import com.cosmos.exceptions.NoDataAvailable;
import com.cosmos.exceptions.NotFoundException;
import com.cosmos.model.Student;
import com.cosmos.repository.StudentReactiveCosmosRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class StudentPUTPOSTDELETEServiceImpl 
{
	@Autowired
	private StudentReactiveCosmosRepository studentReactiveRepo;
	
	public Student createReactiveStudent(Student student) {
		return studentReactiveRepo.save(student)
				.switchIfEmpty(Mono.error(new NotFoundException("Invalid Entity"))).block();
	}
	
	@Transactional
	public Student updateReactiveStudentById(String id, Student student) {
		return studentReactiveRepo.save(student).block();
	}
	
	public void deleteReactiveStudentById(String id) {
		studentReactiveRepo.findById(id).switchIfEmpty(Mono.error(new EntityNotFoundException("ID", id)))
				.flatMap(deleteStudent -> studentReactiveRepo.delete(deleteStudent)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))));
				//.switchIfEmpty(Mono.error(new EntityNotFoundException("ID", id)));
		//.doOnError(t -> {throw new EntityNotFoundException("ID", id);})
	}

	public void deleteAllReactiveStudents() {
		studentReactiveRepo.deleteAll().then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
				.switchIfEmpty(Mono.error(new NoDataAvailable("No Records available",
						"Try to add some records before using this operation")));
	}
	
//	public Flux<ResponseEntity<Student>> saveAllReactiveStudent(List<Student> studentList) {
//	return studentReactiveRepo.saveAll(studentList).map(ResponseEntity::ok)
//			.defaultIfEmpty(ResponseEntity.notFound().build());
//}

	private List<Student> studentsList()
	{
		List<Student> studentsList = new ArrayList<>();
		studentsList.add(new Student("A1335", "S1009", "Monisha", "C1234", "123AB21"));
		studentsList.add(new Student("A7647", "S1004", "Krish", "C1254", "123AB02"));
		studentsList.add(new Student("A1247", "S1046", "Dinesh", "C1124", "123AB02"));
		studentsList.add(new Student("A4632", "S1546", "Mahesh", "164GK13", "C4976"));
		studentsList.add(new Student("A1285", "S987", "Pranavh", "164HH44", "C464"));	
		return studentsList;
	}

}


/*
[
{
  "id": "A1335",
  "studentId": "S1009",
  "studentName": "Monisha",
  "collegeId": "C1234",
  "courseId": "123AB21",
},
{
  "id": "A7647",
  "studentId": "S1004",
  "studentName": "Krish",
  "collegeId": "C1254",
  "courseId": "123AB02",
},
{
  "id": "A1247",
  "studentId": "S1046",
  "studentName": "Dinesh",
  "collegeId": "C1124",
  "courseId": "123AB02",
},
{
  "id": "A4632",
  "studentId": "S1546",
  "studentName": "Mahesh",
  "collegeId": "164GK13",
  "courseId": "C4976",
},
{
  "id": "A1280",
  "studentId": "S987",
  "studentName": "Pranav",
  "collegeId": "164HH44",
  "courseId": "C464",
}
]
*/