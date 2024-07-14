package com.vasquez.exception;
/**
 * @author Jhonatan Vasquez
 * @version 1.0
 * @since 2024-07-14
 */
public class RuntimeExceptionAPIConnection extends RuntimeException {
   private  String message;
    public RuntimeExceptionAPIConnection(String menssage) {
    this.message = menssage;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
