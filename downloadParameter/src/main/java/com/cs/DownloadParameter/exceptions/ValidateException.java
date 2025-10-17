package com.cs.DownloadParameter.exceptions;


public class ValidateException extends Exception{
	
	private static final long serialVersionUID = -4671900243756222360L;
	private String errorCode;
	private String field;
	
	 // Default constructor
  public ValidateException() {
      super(); // Call the superclass constructor
  }

  // Constructor that accepts a message
  public ValidateException(String message) {
      super(message); // Pass the message to the superclass constructor
  }

  // Constructor that accepts a message and a cause
  public ValidateException(String message, Throwable cause) {
      super(message, cause); // Pass the message and cause to the superclass constructor
  }

  // Constructor that accepts a cause
  public ValidateException(Throwable cause) {
      super(cause); // Pass the cause to the superclass constructor
  }
  
  public ValidateException(String message, String errorCode) {
      super(message);
      this.errorCode = errorCode;
  }
  
  public ValidateException(String message, String errorCode, String field) {
	  super(message);
	  this.errorCode = errorCode;
	  this.field = field;
  }

  public String getErrorCode() {
      return errorCode;
  }
  
  public String getField() {
	  return field;
  }
}
