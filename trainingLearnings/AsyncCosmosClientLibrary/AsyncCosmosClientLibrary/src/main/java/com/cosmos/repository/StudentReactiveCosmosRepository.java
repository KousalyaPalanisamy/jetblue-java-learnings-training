package com.cosmos.repository;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.cosmos.model.Student;

@Repository
public interface StudentReactiveCosmosRepository extends ReactiveCosmosRepository<Student, String> {

}
