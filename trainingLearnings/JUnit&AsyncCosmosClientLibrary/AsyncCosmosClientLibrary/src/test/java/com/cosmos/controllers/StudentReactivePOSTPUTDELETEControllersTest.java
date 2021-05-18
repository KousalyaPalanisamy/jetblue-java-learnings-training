package com.cosmos.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import com.cosmos.model.Student;
import com.cosmos.services.StudentReactiveServices;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class StudentReactivePOSTPUTDELETEControllersTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	@MockBean
	private StudentReactiveServices studentReactiveService;

	String stringURI;
	URI uri;

	@BeforeEach
	void init() throws URISyntaxException {
		stringURI = "http://localhost:" + randomServerPort + "/reactiveStudent";
	}

	@AfterEach
	void tearDown() {
		stringURI = null;
	}

	@Test // done
	void testCreateStudent() throws URISyntaxException {
		Student student = studentsList().get(0);
		uri = new URI(stringURI);
		ResponseEntity<Student> response = this.restTemplate.postForEntity(uri, student, Student.class);
		assertEquals(201, response.getStatusCodeValue());
	}

	@Test
	void testUpdateStudent() throws URISyntaxException {
		uri = new URI(stringURI + "A1247");
		Student student = restTemplate.getForObject(uri, Student.class);
		student.setStudentName("Dinesh Kumar");
		restTemplate.put(uri, student);
		Student updatedStudent = restTemplate.getForObject(uri, Student.class);
		assertNotNull(updatedStudent);
	}

	@Test
	void testDeleteStudent() throws URISyntaxException {
		uri = new URI(stringURI + "A1247");
		Student student = restTemplate.getForObject(uri, Student.class);
		assertNotNull(student);
		restTemplate.delete(uri);
		try {
			student = restTemplate.getForObject(uri, Student.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	private List<Student> studentsList() {
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
 * @Test void testExceptionCreateStudent() throws URISyntaxException { Student
 * student = new Student(null, "S2398", "Krithika", "C2398", "s39vs"); uri = new
 * URI(stringURI);
 * 
 * //ResponseEntity<Student> response = restTemplate.postForEntity(uri, student,
 * Student.class); //assertEquals(400, response.getStatusCodeValue());
 * //System.out.println("\n\n"+response.getBody()); //assertEquals(true,
 * response.getBody().contains("Missing required fields"));
 * assertThrows(RestClientException.class, () -> {
 * restTemplate.postForEntity(uri, student, Student.class); }); }
 */