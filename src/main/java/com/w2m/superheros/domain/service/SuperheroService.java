package com.w2m.superheros.domain.service;

import com.w2m.superheros.application.ports.input.SuperheroUseCase;
import com.w2m.superheros.domain.dto.SuperheroDto;
import com.w2m.superheros.domain.mapper.SuperheroMapper;
import com.w2m.superheros.infrastructure.adapters.output.persistence.SuperheroPersistenceAdapter;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperheroService implements SuperheroUseCase {

    @Autowired
    private SuperheroPersistenceAdapter superheroPersistenceAdapter;

    private SuperheroMapper superheroMapper = Mappers.getMapper(SuperheroMapper.class);

    @Override
    public List<SuperheroDto> getAll() {
        return superheroPersistenceAdapter.getAll()
                .stream()
                .map(superheroMapper::toDto)
                .toList();
    }

    @Override
    public SuperheroDto getById(Long id) {
        return Optional.ofNullable(superheroPersistenceAdapter.getById(id))
                .map(superheroMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<SuperheroDto> searchByName(String name) {
        return superheroPersistenceAdapter.searchByName(name)
                .stream()
                .map(superheroMapper::toDto)
                .toList();
    }

    @Override
    public SuperheroDto create(SuperheroDto superheroDto) {
        return Optional.ofNullable(superheroPersistenceAdapter.create(superheroMapper.toEntity(superheroDto)))
                .map(superheroMapper::toDto)
                .orElse(null);
    }

    @Override
    public SuperheroDto modify(SuperheroDto superheroDto) {
        return Optional.ofNullable(superheroPersistenceAdapter.modify(superheroMapper.toEntity(superheroDto)))
                .map(superheroMapper::toDto)
                .orElse(null);
    }

    @Override
    public SuperheroDto delete(Long id) {
        return Optional.ofNullable(superheroPersistenceAdapter.delete(id))
                .map(superheroMapper::toDto)
                .orElse(null);
    }
}
