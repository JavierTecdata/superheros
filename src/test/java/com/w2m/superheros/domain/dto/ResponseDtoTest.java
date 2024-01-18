package com.w2m.superheros.domain.dto;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ResponseDtoTest {

    @Test
    void testResponseDto() {
        assertNotNull(new ResponseDto(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null));
    }

}
