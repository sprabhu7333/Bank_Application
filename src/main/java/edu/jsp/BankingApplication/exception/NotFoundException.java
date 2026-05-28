package edu.jsp.BankingApplication.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class NotFoundException extends RuntimeException{

	private String resourceName;
	private String fieldName;
	private long fieldId;
	
	@Override
	public String getMessage() {
		
		return resourceName + " Not Found for" + fieldName + "=" + fieldId;
	}
}
