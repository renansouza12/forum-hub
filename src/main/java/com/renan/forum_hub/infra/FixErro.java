package com.renan.forum_hub.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class FixErro {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity erro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
       return ResponseEntity.badRequest().body(erros.stream().map(ErroValidation::new).toList());
    }

    private record ErroValidation(String field, String message){
        public ErroValidation(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
