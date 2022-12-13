package com.dh.clinicaOdontologica.exception.handler;

import com.dh.clinicaOdontologica.exception.CadastroInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
//a
    @ExceptionHandler({CadastroInvalidoException.class})
    public ResponseEntity<String> processarErrorCadastroInvalido(CadastroInvalidoException exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
