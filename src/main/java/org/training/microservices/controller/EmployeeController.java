package org.training.microservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.training.microservices.entity.Employee;
import org.training.microservices.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/get-all-employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	@RequestMapping(value = "/get-employee-by-id/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return service.getEmployeeById(id);
	}

	@RequestMapping(value = "/create-employee", method = RequestMethod.POST)
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return service.createEmployee(emp);
	}

	@RequestMapping(value = "/get-employee-by-email/{email}", method = RequestMethod.GET)
	public Employee getEmployeeByEmail(@PathVariable("email") String email) {
		return service.getEmployeeByEmail(email);
	}

	@RequestMapping(value = "/get-employee/{name}/{empCode}", method = RequestMethod.GET)
	public Employee findByEmpNameAndEmpCode(@PathVariable("name") String name,
			@PathVariable("empCode") String empCode) {
		return service.findByEmpNameAndEmpCode(name, empCode);
	}

	@RequestMapping(value = "/get-employees/{name}", method = RequestMethod.GET)
	public List<Employee> findByEmpNameEquals(@PathVariable("name") String name) {
		return service.findByEmpNameEquals(name);
	}

	@RequestMapping(value = "/get-employees-name-not/{name}", method = RequestMethod.GET)
	public List<Employee> findByEmpNameIsNot(@PathVariable("name") String name) {
		return service.findByEmpNameIsNot(name);
	}

	@RequestMapping(value = "/get-employees/name/{prefix}", method = RequestMethod.GET)
	public List<Employee> findByEmpNameStartingWith(@PathVariable("prefix") String prefix) {
		return service.findByEmpNameStartingWith(prefix);
	}

	@RequestMapping(value = "/get-employees-like/{likePattern}", method = RequestMethod.GET)
	public List<Employee> findByEmpNameLike(@PathVariable String likePattern) {
		return service.findByEmpNameLike("%" + likePattern + "%");
	}

	@RequestMapping(value = "/get-old-age-employee", method = RequestMethod.GET)
	public Employee findTopByAge() {
		return service.findTopByOrderByAgeDesc();
	}

	@RequestMapping(value = "/get-top-age-employee/{age}", method = RequestMethod.GET)
	public List<Employee> findTop3ByAge(@PathVariable("age") int age) {
		return service.findTop3ByAge(age);
	}

	@RequestMapping(value = "/get-top3-age-employee/{age}", method = RequestMethod.GET)
	public List<Employee> findTop3ByAgeLessThanOrderByAgeDesc(@PathVariable("age") int age) {
		return service.findTop3ByAgeLessThanOrderByAgeDesc(age);
	}
	@RequestMapping(value = "/save-employees", method = RequestMethod.POST)
	public List<Employee>addEmployeeList(@Valid @RequestBody List<Employee>listOfEmployee){
		return service.addEmployeeList(listOfEmployee);
	}
}
