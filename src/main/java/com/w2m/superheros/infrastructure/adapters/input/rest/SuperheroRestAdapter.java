package com.w2m.superheros.infrastructure.adapters.input.rest;

import com.w2m.superheros.domain.dto.ResponseDto;
import com.w2m.superheros.domain.dto.SuperheroDto;
import com.w2m.superheros.domain.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/w2m/v1")
public class SuperheroRestAdapter {

    @Autowired
    private SuperheroService superheroService;

    @GetMapping(path = "/superhero")
    public ResponseEntity<ResponseDto> getAll() {
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), superheroService.getAll()));
    }

    @GetMapping(path = "/superhero/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), superheroService.getById(Long.valueOf(id))));
    }

    @GetMapping(path = "/superhero/search")
    public ResponseEntity<ResponseDto> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), superheroService.searchByName(name)));
    }

    @PostMapping(path = "/superhero")
    public ResponseEntity<ResponseDto> create(@RequestBody SuperheroDto superheroDto) {
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), superheroService.create(superheroDto)));
    }

    @PutMapping(path = "/superhero")
    public ResponseEntity<ResponseDto> modify(@RequestBody SuperheroDto superheroDto) {
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), superheroService.modify(superheroDto)));
    }

    @DeleteMapping(path = "/superhero/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), superheroService.delete(Long.valueOf(id))));
    }

}
