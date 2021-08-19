package org.training.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.training.microservices.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByEmpEmail(String email);
	public Employee findByEmpNameAndEmpCode(String name,String empCode);
	public List<Employee> findByEmpNameEquals(String name);
	public List<Employee> findByEmpNameIsNot(String name);
	public List<Employee> findByEmpNameStartingWith(String prefix);
	public List<Employee> findByEmpNameLike(String likePattern);
	public Employee findTopByOrderByAgeDesc();
	public List<Employee>findTop3ByAge(int age);
	public List<Employee> findTop3ByAgeLessThanOrderByAgeDesc(int age);
}
