package com.cosmos.serviceImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azure.cosmos.models.PartitionKey;
import com.cosmos.exceptions.EntityNotFoundException;
import com.cosmos.exceptions.NoDataAvailable;
import com.cosmos.model.Student;
import com.cosmos.repository.StudentReactiveCosmosRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class StudentGETServiceImpl 
{
	@Autowired
	private StudentReactiveCosmosRepository studentReactiveRepo;
	
	public List<Student> listAllReactiveStudents() {
		return studentReactiveRepo.findAll()
				.switchIfEmpty(Flux.error(new NoDataAvailable("No Records available", "Try to add some records before using this operation")))
				.collectList()
				.block();
	}
	
	public Student getReactiveStudentById(String id) {
		return studentReactiveRepo.findById(id)
				.switchIfEmpty(Mono.error(new EntityNotFoundException("ID", id))).block();
	}
	
	public List<Student> listAllStudentsByPartitionKey(String partitionKey) {
		return studentReactiveRepo.findAll(new PartitionKey(partitionKey))
				.switchIfEmpty(Flux.error(new EntityNotFoundException("PartitionKey", partitionKey))).collectList().block();
	}
	
	public Student listStudentByIdWithPartitionKey(String id, String partitionKey) {
		return studentReactiveRepo.findById(id, new PartitionKey(partitionKey))
				.switchIfEmpty(Mono.error(new EntityNotFoundException("ID and Partition Key", id+" and "+partitionKey))).block();
	}
	
	
}
