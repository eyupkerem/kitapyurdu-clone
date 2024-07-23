package com.kitapyurdum_clone.exception;

import com.kitapyurdum_clone.dto.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(KitapYurdumException.class)
    public ResponseEntity<GenericResponse> handleException(KitapYurdumException exception){

        return GenericResponse.buildFailResponse(exception.getMessage());

    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GenericResponse> handleException(RuntimeException exception){

        return new  ResponseEntity<>(
                GenericResponse.builder()
                        .message(exception.getMessage())
                        .date(LocalDateTime.from(LocalDate.from(LocalDateTime.now())))
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build()
                , HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }
}
