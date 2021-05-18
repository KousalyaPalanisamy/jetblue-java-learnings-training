package com.programs.controllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.UnsupportedMediaTypeException;
import org.springframework.web.reactive.function.client.WebClient;

import com.programs.exceptions.EmptyFieldException;
import com.programs.model.Employee;
import com.programs.service.DataService;

@RestController
@RequestMapping("/api/details")
public class OperationsController 
{
	@Autowired
	private DataService empService;
	
	@GetMapping//(produces = {"application/xml"})
	public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo, 
            													@RequestParam(defaultValue = "10") Integer pageSize)
	{
		return new ResponseEntity<>(empService.getAllEmployees(pageNo, pageSize), new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/{empid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empid")int empId)
	{
		return new ResponseEntity<>(empService.getEmployeeById(empId), HttpStatus.OK);
	}
	
	@GetMapping("/webclient/{id}")
	public ResponseEntity<Employee> retrieveEmployee(@PathVariable("id")int empId)
	{
		return new ResponseEntity<>(empService.retrieveEmployee(empId), HttpStatus.OK);
		
	}
	@PostMapping//(consumes={"application/xml"})
	//@RequestMapping(method=RequestMethod.POST, consumes={"application/xml"})
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee eData)
	{
		return new ResponseEntity<>(empService.saveData(eData), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Employee> saveOrUpdateEmployee(@RequestBody Employee eData)
	{
		empService.update(eData);
		return new ResponseEntity<>(eData, HttpStatus.OK);
	}
	
	@DeleteMapping("/{empId}")
	public void deleteEmployee(@PathVariable("empId")int empId)
	{
		empService.deleteData(empId);
	}
	
//	@GetMapping
//	public ResponseEntity<List<Employee>> filterEmployeesByLocation(@RequestParam(required=false) String location)
//	{
//		return new ResponseEntity<>(empService.filterByLocation(location), HttpStatus.OK);
//	}
	
	@ExceptionHandler(EmptyFieldException.class)
	public String handleEmptyFieldException(EmptyFieldException e)
	{
		return e.getMessage();
	}
	
	@ExceptionHandler({UnsupportedMediaTypeException.class})
	  public ResponseEntity<String> exceptionHandler(Exception ex) {
	    return ResponseEntity.badRequest().body(ex.getMessage());
	  }
}
















//@GetMapping(produces=MediaType.APPLICATION_XML_VALUE)
	//@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)

/*
@GetMapping
private ResponseEntity<List<EmployeeModel>> getAllEmployees()
{
	return new ResponseEntity<>(empService.getAllEmployees(),HttpStatus.OK);
}
*/