package com.w2m.superheros.infrastructure.adapters.input.rest.errorhandler;

import com.w2m.superheros.domain.dto.ResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void handleEmptyResultDataAccessException() {
        EmptyResultDataAccessException ex = new EmptyResultDataAccessException(1);

        ResponseEntity<ResponseDto> response = globalExceptionHandler.handleEmptyResultDataAccessException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void handleEntityNotFoundException() {
        EntityNotFoundException ex = new EntityNotFoundException("Entity not found");

        ResponseEntity<ResponseDto> response = globalExceptionHandler.handleEntityNotFoundException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void handleException() {
        Exception ex = new Exception("Internal Server Error");

        ResponseEntity<ResponseDto> response = globalExceptionHandler.handleException(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
