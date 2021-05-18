package com.programs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.programs.model.Employee;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<Employee, Integer>
{
	@Query("FROM Employee WHERE empId = ?1")
	Optional<Employee> findByempId(int empId);
		
	void deleteByempId(int empId);
	
	@Query(value = "Select e from Employee e where LOWER(e.location)=LOWER(:location)")
	List<Employee> findBylocation(@Param(value = "location") String location);
}
