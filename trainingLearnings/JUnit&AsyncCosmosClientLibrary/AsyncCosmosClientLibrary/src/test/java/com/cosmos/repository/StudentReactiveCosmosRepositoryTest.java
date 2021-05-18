package com.cosmos.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cosmos.model.Student;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
class StudentReactiveCosmosRepositoryTest {

//	@Autowired
//	private TestEntityManager entityManager;
	
	@Autowired
	private StudentReactiveCosmosRepository studentRepo;
	
	@Test
	void testFindAll() {
		List<Student> studentsList = studentRepo.findAll().collectList().block();
		assertTrue(studentsList.size() > 0);	
	}
	
//	@Test
//	void testfindById() {
//		Student student1 = studentsList().get(0);
//		Student savedInDb = entityManager.persist(student1);
//		Student getFromDb = studentRepo.findById(savedInDb.getId()).block();
//		assertThat(savedInDb).isEqualTo(getFromDb);
//	}	

//	@Test
//	void testSave() {
//		Student savedInDb = entityManager.persist(getStudent1());
//		Student getFromDb = studentRepo.findById(savedInDb.getEnrollId()).orElse(null);
//		assertThat(getFromDb).isEqualTo(savedInDb);
//	}
//
//	@Test
//	void testDelete() {
//		List<Student> studentListBefore = studentRepo.findAll();
//		Student student = entityManager.persist(getStudent1());
//		entityManager.persist(getStudent2());
//		entityManager.remove(student);
//		
//		List<Student> studentListAfter = studentRepo.findAll();
//		assertThat(studentListAfter.size()).isEqualTo(studentListBefore.size()+1);
//
//	}

	
	void testSaveAll()
	{
		List<Student> sList = new ArrayList<>();
//		sList.add(entityManager.persist(studentsList().get(0)));
//		sList.add(entityManager.persist(studentsList().get(1)));
//		sList.add(entityManager.persist(studentsList().get(2)));
//		sList.add(entityManager.persist(studentsList().get(3)));
//		sList.add(entityManager.persist(studentsList().get(4)));
		
	}
	
	private List<Student> studentsList()
	{
		List<Student> studentsList = new ArrayList<>();
		studentsList.add(new Student("A1335", "S1009", "Monisha", "C1234", "123AB21"));
		studentsList.add(new Student("A7647", "S1004", "Krish", "C1254", "123AB02"));
		studentsList.add(new Student("A1247", "S1046", "Dinesh", "C1124", "123AB02"));
		studentsList.add(new Student("A4632", "S1546", "Mahesh", "164GK13", "C4976"));
		studentsList.add(new Student("A1285", "S987", "Pranavh", "164HH44", "C464"));	
		return studentsList;
	}
}
