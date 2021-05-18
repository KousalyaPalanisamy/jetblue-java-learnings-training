package com.programs.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.programs.exceptions.EmptyFieldException;
import com.programs.model.Employee;
import com.programs.repository.EmployeeDetailsRepository;

@Service
@Transactional
public class DataService 
{
	@Autowired
	private EmployeeDetailsRepository empRepo;
	
	@Autowired
	private WebClient.Builder webclient;

	Supplier<Instant> currentTime = () -> Instant.now();
	
	public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize)
	{
		Pageable paging = PageRequest.of(pageNo, pageSize);
		 
        Page<Employee> pagedResult = empRepo.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>(); //blank object
        }
	}
	
	public Employee retrieveEmployee(int empId)
	{
		System.out.println("In retreive");
		return webclient.baseUrl("http://localhost:8090/api/details").build()
				.get()
				.uri(uriBuilder -> uriBuilder
					    .path("/"+empId)
					    .build())
				.retrieve()
				.bodyToMono(Employee.class)
				.block();
		
	}
	
	public Employee getEmployeeById(int eId)
	{
		return empRepo.findByempId(eId).orElse(new Employee());
	}
	
	
	public List<Employee> filterByLocation(String location)
	{
		if(Objects.isNull(location))
			return this.getAllEmployees(0,10);
		else
			return empRepo.findBylocation(location);
	}
	
	
	public Employee saveData(Employee emp)
	{
		if(emp.getEmpId() == 0)
		{
			throw new EmptyFieldException("The field empId must contain a value");
		}
		emp.setCreatedDateTime(currentTime.get());
		emp.setLastModifiedDateTime(currentTime.get());
		return empRepo.save(emp);
	}

	public Employee update(Employee emp)
	{
		Employee existingData = empRepo.findByempId(emp.getEmpId()).orElse(empRepo.save(emp));	
		emp.setSno(existingData.getSno());
		if(Objects.isNull(emp.getName()))
			emp.setName(existingData.getName());
		if(Objects.isNull(emp.getDesignation()))
			emp.setDesignation(existingData.getDesignation());
		if(Objects.isNull(emp.getLocation()))
			emp.setLocation(existingData.getLocation());
		
		emp.setCreatedDateTime(existingData.getCreatedDateTime());
		emp.setLastModifiedDateTime(currentTime.get());
		
		empRepo.delete(existingData);
		empRepo.save(emp);
		return emp;
	}

	public void deleteData(int empId) 
	{		
		empRepo.deleteByempId(empId);
	}
	
	 
}




/*
 
 		List<EmployeeEntity> data = new ArrayList<>();
		empRepo.findAll().forEach(employee -> data.add(employee));
		return data;

*/