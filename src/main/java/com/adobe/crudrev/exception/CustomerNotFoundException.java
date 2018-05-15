package com.adobe.crudrev.exception;

public class CustomerNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2107153648781063747L;
	private String errorMessage;
	 
    public CustomerNotFoundException(String errorMessage){
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }


}
