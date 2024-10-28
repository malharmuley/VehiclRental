package com.cg.ovms.exceptionhandling.advice;




import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.ovms.exceptionhandling.exceptiion.EmptyInputException;
import com.cg.ovms.exceptionhandling.exceptiion.ExistingUserException;

@ControllerAdvice	

public class MyControllerAdvice extends ResponseEntityExceptionHandler{
	/*@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException)
	{
		return new  ResponseEntity<String>("No such value is present in DB, Please change your request",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException elementException)
	{
		return new  ResponseEntity<String>("No such value is present in DB, Please change your request",HttpStatus.BAD_REQUEST);
	}*/
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		return new  ResponseEntity<Object>("Please change the Http method type",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException elementException)
	{
		return new ResponseEntity<String>("Input field is empty, Please look into it",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleEmptyInputException(Exception elementException)
	{
		return new  ResponseEntity<String>(elementException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ExistingUserException.class)
    public ResponseEntity<String> handleExistingUserException(ExistingUserException el) {
        return new ResponseEntity<String>(el.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
