package com.example.demo.exception;

public class DuplicateFieldNameException extends GeneralException{
    public DuplicateFieldNameException(Object errorClass, Object errorField) {
        this.setErrorMessage("FIELD_DUPLICATE");
        this.setErrorClass(errorClass);
        this.setErrorField(errorField.toString());
    }
}
