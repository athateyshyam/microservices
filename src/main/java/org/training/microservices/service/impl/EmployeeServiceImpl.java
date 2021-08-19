package org.training.microservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.microservices.entity.Employee;
import org.training.microservices.exceptions.EmployeeServiceException;
import org.training.microservices.exceptions.errormessages.ErrorMessages;
import org.training.microservices.repository.EmployeeRepository;
import org.training.microservices.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee createEmployee(Employee emp) {
		if (emp.getEmpName().isEmpty() || emp.getEmpCode().isEmpty() || emp.getEmpEmail().isEmpty())
			throw new EmployeeServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		if (repo.findByEmpEmail(emp.getEmpEmail())!= null)
			throw new EmployeeServiceException(ErrorMessages.EMAIL_ALREADY_EXISTS.getErrorMessage());
		if (emp.getAge() <= 18 || emp.getAge() > 150)
			throw new EmployeeServiceException(ErrorMessages.AGE_BEYOND_LIMIT.getErrorMessage());
		return repo.save(emp);
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		if (repo.findByEmpEmail(email) == null)
			throw new EmployeeServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		return repo.findByEmpEmail(email);
	}

	@Override
	public Employee findByEmpNameAndEmpCode(String name, String empCode) {
		return repo.findByEmpNameAndEmpCode(name, empCode);
	}

	@Override
	public List<Employee> findByEmpNameEquals(String name) {
		return repo.findByEmpNameEquals(name);
	}

	@Override
	public List<Employee> findByEmpNameIsNot(String name) {
		return repo.findByEmpNameIsNot(name);
	}

	@Override
	public List<Employee> findByEmpNameStartingWith(String prefix) {
		return repo.findByEmpNameStartingWith(prefix);
	}

	@Override
	public List<Employee> findByEmpNameLike(String likePattern) {
		return repo.findByEmpNameLike(likePattern);
	}

	@Override
	public Employee findTopByOrderByAgeDesc() {
		return repo.findTopByOrderByAgeDesc();
	}

	@Override
	public List<Employee> findTop3ByAge(int age) {
		return repo.findTop3ByAge(age);
	}

	@Override
	public List<Employee> findTop3ByAgeLessThanOrderByAgeDesc(int age) {
		return repo.findTop3ByAgeLessThanOrderByAgeDesc(age);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		if(!repo.findById(id).isPresent())
			throw new EmployeeServiceException("Employee Id: "+id+" not found in database");
		return repo.findById(id).get();
	}

	@Override
	public List<Employee> addEmployeeList(List<Employee> listOfEmployee) {
		return repo.saveAll(listOfEmployee);
	}


}
