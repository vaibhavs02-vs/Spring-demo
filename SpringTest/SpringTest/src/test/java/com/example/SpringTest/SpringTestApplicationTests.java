package com.example.SpringTest;

import com.example.SpringTest.controller.CrudController;
import com.example.SpringTest.controller.GetController;
import com.example.SpringTest.model.Student;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringTestApplicationTests {
	@Autowired
	GetController controller;

	@Autowired
	CrudController crudController;

	@Test
	@Order(1)
	public void testDTOAvailableOrNot(){
		try {
			Student student = new Student();
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(2)
	public void testDTOAvailableOrNotCheckStudent(){
		try {
			Student student = new Student();
			student.getAddress();
			student.getDob();
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(3)
	public void testControllerAllStudents(){
		try {
			List<Student> list = controller.getAllStudents();
			assertNotNull(list);
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(4)
	public void testController2(){
		try {
			List<Student> list = controller.getAllStudents();
			assertEquals(list.get(0).getSid(), "101");
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(4)
	public void testController3(){
		try {
			Optional<Student> list = controller.getAnyStudent("101");
			assertNotNull(list);
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(5)
	public void testController4(){
		try {
			Optional<Student> list = controller.getAnyStudent("5000");
			assertEquals(list, Optional.empty());
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(6)
	public void testCrudControllerInsertion(){
		try {
			Student student = new Student();
			student.setSid("150");
			student.setAddress("abc, def");
			student.setFname("Gamma");
			student.setLname("Delta");
			student.setDob("1991-01-01");
			String result = crudController.insertStudent(student);
			assertEquals(result, "Data is Inserted");
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(6)
	public void testCrudControllerUpdate(){
		try {
			Student student = new Student();
			student.setSid("150");
			student.setAddress("abc, def");
			student.setFname("Zeta");
			student.setLname("Delta");
			student.setDob("1991-01-01");
			String result = crudController.updateStudent(student);
			assertEquals(result, "Data is Updated");
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(7)
	public void testCrudControllerDelete(){
		try {
			String result = crudController.deleteStudent("150");
			assertEquals(result, "Data is Deleted");
		} catch (Exception e){
			fail();
		}
	}

}

