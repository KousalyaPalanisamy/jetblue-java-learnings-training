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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cosmos.model.Student;
import com.cosmos.services.StudentReactiveServices;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentReactiveGETControllersTest {
	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	int randomServerPort;
	@MockBean
	private StudentReactiveServices studentReactiveService;

	String stringURI;
	URI uri ;
	
	@BeforeEach 
    void init() throws URISyntaxException {
		stringURI =  "http://localhost:" + randomServerPort + "/reactiveStudent";
	}
	
	@AfterEach
	void tearDown()
	{
		stringURI = null;
	}
	@Test
	void testListAllStudents() throws URISyntaxException {
		uri = new URI(stringURI);
		Mockito.when(studentReactiveService.listAllReactiveStudents()).thenReturn(studentsList());
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		System.out.println(response.getBody());
		assertEquals(200, response.getStatusCodeValue());
		assertNotNull(response.getBody());
	}



	@Test
	void testGetStudentById() throws URISyntaxException {
		uri = new URI(stringURI+"A1247");
		Mockito.when(studentReactiveService.getReactiveStudentById(Mockito.anyString())).thenReturn(studentsList().get(2));
		Student student = restTemplate.getForObject(uri, Student.class);
        System.out.println(student.getStudentName());
        assertNotNull(student);
	}

//	@Test
//	void testListAllStudentsByPartitionKey() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetStudentByIdWithPartitionKey() {
//		fail("Not yet implemented");
//	}

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


















//@Test
//void testListAllStudents() {
//	when(studentReactiveService.listAllReactiveStudents()).thenReturn(studentsList());
//	webTestClient.get().uri("/reactiveStudent")
//			.header(HttpHeaders.ACCEPT, "application/json")
//			.exchange()
//			.expectStatus().isOk()
//			.expectBody()
//			.jsonPath("$.length()").isEqualTo(5)
//			.jsonPath("$[0].id").isEqualTo("A1335")
//			.jsonPath("$[1].id").isEqualTo("A7647")
//			.jsonPath("$[2].id").isEqualTo("A1247")
//			.jsonPath("$[3].id").isEqualTo("A4632")
//			.jsonPath("$[4].id").isEqualTo("A1285");	
//}