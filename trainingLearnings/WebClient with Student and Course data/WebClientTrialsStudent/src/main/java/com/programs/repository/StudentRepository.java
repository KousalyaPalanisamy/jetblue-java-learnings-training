package com.programs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.programs.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>
{
	@Query("Select s from Student s where studentId = ?1")
	List<Student> findBystudentId(@Param("studentId")int studentId);
}
