package com.juaracoding.pcmspringboot31.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//work motion
//time motion
@RestControllerAdvice
@Configuration
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    @Nullable
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        return super.handleMethodArgumentNotValid(ex, headers, status, request);
        List<Map<String,Object>>  errors = new ArrayList<>();
        for ( FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            Map<String,Object> m = Map.of(
                    "field",fieldError.getField(),
                    "default_message",fieldError.getDefaultMessage(),
                    "rejected_value",fieldError.getRejectedValue()
            );
            errors.add(m);
        }
        return ResponseEntity.internalServerError().body(errors);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleException(Exception e, HttpServletRequest request) {
        //input ke file log Log4J2
        return ResponseEntity.internalServerError().body("Proses Gagal !!");
    }
}
