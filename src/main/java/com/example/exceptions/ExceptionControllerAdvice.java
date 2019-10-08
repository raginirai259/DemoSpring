package com.example.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dto.ErrorMessage;

@RestControllerAdvice
public class ExceptionControllerAdvice{
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public String ExceptionHandler(Exception ex)
	{
		return ex.getMessage();
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundExecption.class)
	public ResponseEntity<ErrorMessage> expHandler(ProductNotFoundExecption ex){
		
		ErrorMessage err=new ErrorMessage();
		err.setErrorCode(HttpStatus.BAD_REQUEST.value());
		err.setMessage(ex.getMessage());
		return new ResponseEntity<>(err,HttpStatus.OK);
		
	}
}
