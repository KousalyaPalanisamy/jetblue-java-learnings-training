package com.cosmos.serviceImplementations;
//all done
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.azure.cosmos.implementation.apachecommons.collections.CollectionUtils;
import com.azure.cosmos.models.PartitionKey;
import com.cosmos.exceptions.EntityNotFoundException;
import com.cosmos.exceptions.NoDataAvailable;
import com.cosmos.model.Student;
import com.cosmos.repository.StudentReactiveCosmosRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(StudentGETServiceImpl.class)
class StudentGETServiceImplTest {
//	@Autowired
//	private MockMvc mockMvc;
	@Autowired
	private StudentGETServiceImpl studentGetService;
	@MockBean
	private StudentReactiveCosmosRepository studentRepo;

	@Test
	void testListAllReactiveStudents() {
		Mockito.when(studentRepo.findAll()).thenReturn(Flux.fromIterable(studentsList()));
		List<Student> serviceResult = studentGetService.listAllReactiveStudents();	
		assertFalse(serviceResult.isEmpty());
//		assertAll(() -> assertEquals(serviceResult.get(0).getId(), studentsList().get(0).getId()),
//				() -> assertEquals(serviceResult.get(1).getId(), studentsList().get(1).getId()),
//				() -> assertEquals(serviceResult.get(2).getId(), studentsList().get(2).getId()),
//				() -> assertEquals(serviceResult.get(3).getId(), studentsList().get(3).getId()),
//				() -> assertEquals(serviceResult.get(4).getId(), studentsList().get(4).getId()));
//		System.out.println(serviceResult+"\n\n"+studentsList());
		assertThat(serviceResult).containsExactlyInAnyOrderElementsOf(studentsList());
	}
	
	@Test
	void testExceptionListAllReactiveStudents() {
		Mockito.when(studentRepo.findAll()).thenThrow(new NoDataAvailable("No Records available", "Try to add some records before using this operation"));
		assertThrows(NoDataAvailable.class, () ->{
			studentGetService.listAllReactiveStudents();
		});
	}

	@Test
	void testGetReactiveStudentById() {
		Student student = studentsList().get(0);
		Mockito.when(studentRepo.findById(Mockito.anyString())).thenReturn(Mono.just(student));
		assertEquals(studentGetService.getReactiveStudentById(student.getId()), student);
	}

	@Test
	void testExceptionGetReactiveStudentById() {
		Mockito.when(studentRepo.findById(Mockito.anyString())).thenThrow(new EntityNotFoundException("ID", "A1234"));
		assertThrows(EntityNotFoundException.class, () -> {
			studentGetService.getReactiveStudentById("A1234");
		});
	}

	@Test
	void testListAllStudentsByPartitionKey() {
		List<Student> studentList = new ArrayList<>();
		studentList.add(studentsList().get(1));
		studentList.add(studentsList().get(2));
		Mockito.when(studentRepo.findAll(new PartitionKey("123AB02"))).thenReturn(Flux.fromIterable(studentList));
		List<Student> serviceResult = studentGetService.listAllStudentsByPartitionKey("123AB02");
		assertFalse(serviceResult.isEmpty());
		assertThat(serviceResult.containsAll(studentsList()));
	}
//
//	@Test
//	void testListStudentByIdWithPartitionKey() {
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
