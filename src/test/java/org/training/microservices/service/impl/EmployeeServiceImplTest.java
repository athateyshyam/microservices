package org.training.microservices.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.training.microservices.entity.Employee;
import org.training.microservices.repository.EmployeeRepository;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
class EmployeeServiceImplTest {
	@Autowired
	private EmployeeRepository repo;

	@Test
	@Rollback(false)
	@Order(1)
	// @Disabled
	void testCreateEmployee() {
		Employee e = repo.save(new Employee(1L, "Jack", "JAC1001", "8745789512", "jack@gmail.co.in", 30));
		assertThat(e.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	void testGetEmployeeByEmail() {
		Employee e = repo.findByEmpEmail("jack@gmail.co.in");
		assertThat(e.getEmpEmail()).isEqualTo("jack@gmail.co.in");
	}

	@Test
	@Order(3)
	public void testGetEmployeeById() {
		Employee e = repo.findById(1L).get();
		assertThat(e.getId()).isEqualTo(1L);
	}

	@Test
	@Order(6)
	public void testGetEmployeeById_NotPresentInDB() {
		Exception ex = assertThrows(NoSuchElementException.class, () -> repo.findById(10L).get());
		String expectedMessage = "No value present";
		String actualMessage = ex.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@Order(4)
	public void getAllEmployees() {
		List<Employee> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(5)
	@Rollback(false)
	public void findByEmpNameAndEmpCode() {
		Employee e = repo.findByEmpNameAndEmpCode("Jack", "JAC1001");
		assertThat(e.getEmpName()).isEqualTo("Jack");
		assertThat(e.getEmpCode()).isEqualTo("JAC1001");
	}
}
