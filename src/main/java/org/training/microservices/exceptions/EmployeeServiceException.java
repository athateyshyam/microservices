package org.training.microservices.exceptions;

public class EmployeeServiceException extends RuntimeException {

	private static final long serialVersionUID = 4505247474526968602L;

	public EmployeeServiceException(String message) {
		super(message);
	}

}
