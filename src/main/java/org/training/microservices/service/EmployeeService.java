package org.training.microservices.service;

import java.util.List;

import org.training.microservices.entity.Employee;

public interface EmployeeService {
	public List<Employee>addEmployeeList(List<Employee>listOfEmployee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Long id);
	public Employee createEmployee(Employee emp);
	public Employee getEmployeeByEmail(String email);
	public Employee findByEmpNameAndEmpCode(String name,String empCode);
	public List<Employee> findByEmpNameEquals(String name);
	public List<Employee> findByEmpNameIsNot(String name);
	public List<Employee> findByEmpNameStartingWith(String prefix);
	public List<Employee> findByEmpNameLike(String likePattern);
	public Employee findTopByOrderByAgeDesc();
	public List<Employee>findTop3ByAge(int age);
	public List<Employee> findTop3ByAgeLessThanOrderByAgeDesc(int age);
}
