package com.welldone.springboot.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource Not Found: ID - " + id);
    }
}
