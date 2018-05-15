package com.adobe.crudrev.exception;

public class AddressValidatorException extends Exception {
	private static final long serialVersionUID = -1574150939421729416L;
	private String errorMessage;
	 
    public AddressValidatorException(String errorMessage){
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }

}
