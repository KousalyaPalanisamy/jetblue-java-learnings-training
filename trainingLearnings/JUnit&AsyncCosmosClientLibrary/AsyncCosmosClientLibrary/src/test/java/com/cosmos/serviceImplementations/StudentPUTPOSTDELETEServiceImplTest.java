package com.cosmos.serviceImplementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atMost;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cosmos.exceptions.EntityNotFoundException;
import com.cosmos.model.Student;
import com.cosmos.repository.StudentReactiveCosmosRepository;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(StudentGETServiceImpl.class)
class StudentPUTPOSTDELETEServiceImplTest {

	@Autowired
	private StudentPUTPOSTDELETEServiceImpl studentPPDService;
	@MockBean
	private StudentReactiveCosmosRepository studentRepo;
	@Test
	void testCreateReactiveStudent() {
		Mockito.when(studentRepo.save(Mockito.any(Student.class))).thenReturn(Mono.just(studentsList().get(0)));
		assertEquals((studentPPDService.createReactiveStudent(studentsList().get(0))).getId(), studentsList().get(0).getId());
	}

	@Test
	void testDeleteReactiveStudentById() {
		Mockito.when(studentRepo.findById("A1285")).thenReturn(Mono.just(studentsList().get(4)));
		studentPPDService.deleteReactiveStudentById("A1285");
		Mockito.verify(studentRepo, atMost(1)).delete(studentsList().get(4));
	}
	
	//@Test
	void testExceptionDeleteReactiveStudentById()
	{
		Mockito.when(studentRepo.findById("A1234")).thenReturn(Mono.empty());
		assertThrows(EntityNotFoundException.class, () -> {
			studentPPDService.deleteReactiveStudentById("A1234");
		});
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
//		Throwable thrown = catchThrowable(() -> studentPPDService.deleteReactiveStudentById("A1234"));
//		assertThat(thrown).isExactlyInstanceOf(EntityNotFoundException.class);
//		EntityNotFoundException e = (EntityNotFoundException) thrown;
//		assertThat(e.getValue()).isEqualTo("A1234");	
 * 
 * @Test
	void testUpdateReactiveStudentById() {
		fail("Not yet implemented");
	}
 */
