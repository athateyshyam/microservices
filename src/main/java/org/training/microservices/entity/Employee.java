package org.training.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "emp_tbl")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String empName;
	@Column(name = "code", unique = true)
	private String empCode;
	@Size(min = 10, max = 10, message = "Mobile number must contains 10 digits only")
	@Column(name = "mobile")
	private String empMobile;
	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is mandatory")
	@Column(name = "email", unique = true)
	private String empEmail;
	@Min(value = 18, message = "Age should not be less than 18")
	@Max(value = 150, message = "Age should not be greater than 150")
	@Column(name = "age")
	private Integer age;

	public Employee() {
		super();
	}

	public Employee(Long id, String empName, String empCode, String empMobile, String empEmail, Integer age) {
		super();
		this.id = id;
		this.empName = empName;
		this.empCode = empCode;
		this.empMobile = empMobile;
		this.empEmail = empEmail;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empCode=" + empCode + ", empMobile=" + empMobile + ", empEmail="
				+ empEmail + ", age=" + age + "]";
	}

}
