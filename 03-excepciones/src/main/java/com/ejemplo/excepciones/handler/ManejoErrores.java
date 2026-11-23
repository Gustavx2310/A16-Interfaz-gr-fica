package com.ejemplo.excepciones.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejoErrores {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handlerArithmeticException(ArithmeticException error) {
        return new ResponseEntity<>(
                "Error: División entre cero no permitida",
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNullPointerException(NullPointerException error) {
        return new ResponseEntity<>(
                "Error: Valor de variable no debe ser nulo",
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handlerNumberFormatException(NumberFormatException error) {
        return new ResponseEntity<>(
                "Error: Formato de valor ingresado es incorrecto",
                HttpStatus.BAD_REQUEST
        );
    }
}
