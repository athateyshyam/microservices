package org.training.microservices.exceptions.errormessages;

public enum ErrorMessages {
	NO_RECORD_FOUND("Employee record not found in database"),
	MISSING_REQUIRED_FIELD("Missing required field"),
	EMAIL_ALREADY_EXISTS("Email already exists. Try with another email"),
	AGE_BEYOND_LIMIT("Age must greater than 0 and less than 150 Yrs");

	private String errorMessage;

	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
