package com.cg.ovms.exceptionhandling.exceptiion;

public class ExistingUserException extends RuntimeException{
	 private static final long serialVersionUID = 6766675245651008270L;
	    
	    private String message;

	    public ExistingUserException() {}
	    public ExistingUserException(String message) {
	        super();
	        this.message = message;
	    }
	    public String getMessage() {
	        return message;
	    }
	

}
