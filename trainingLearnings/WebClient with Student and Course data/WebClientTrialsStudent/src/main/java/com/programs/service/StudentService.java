package com.programs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programs.model.Student;
import com.programs.repository.StudentRepository;

@Service
@Transactional
public class StudentService 
{
	@Autowired
	private StudentRepository studentRepo;

	public List<Student> listAllStudents() 
	{	
		return studentRepo.findAll();
	}
	
	public Student getStudentByEnrollId(String enrollId )
	{
		return studentRepo.findById(enrollId).orElseThrow(()->new IllegalArgumentException("The enroll Id "+enrollId+" is not found"));
	}
	
	public List<Student> getStudentByStudentId(int studentId)
	{
		return studentRepo.findBystudentId(studentId);
	}
	
	public Student saveStudent(Student student)
	{
		return studentRepo.save(student);
	}
	
	public void deleteStudent(String enrollId)
	{
		studentRepo.deleteById(enrollId);
	}
}
