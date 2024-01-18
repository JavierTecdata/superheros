package com.w2m.superheros.infrastructure.adapters.input.rest.errorhandler;

import com.w2m.superheros.domain.dto.ResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ResponseDto> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        return ResponseEntity.badRequest()
                .body(new ResponseDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ex.getCause()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseDto> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.badRequest()
                .body(new ResponseDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ex.getCause()));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleException(Exception ex) {
        return ResponseEntity.internalServerError()
                .body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), ex.getCause()));
    }

}
