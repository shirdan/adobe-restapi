package com.adobe.crudrev.exception;

public class InvalidRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8259682258476228682L;
	private String errorMessage;
	 
    public InvalidRequestException(String errorMessage){
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }


}
