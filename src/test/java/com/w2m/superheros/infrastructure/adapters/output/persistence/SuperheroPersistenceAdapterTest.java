package com.w2m.superheros.infrastructure.adapters.output.persistence;

import com.w2m.superheros.domain.dto.SuperheroDto;
import com.w2m.superheros.domain.entity.SuperheroEntity;
import com.w2m.superheros.domain.mapper.SuperheroMapper;
import com.w2m.superheros.infrastructure.adapters.output.persistence.repository.SuperheroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SuperheroPersistenceAdapterTest {

    @InjectMocks
    SuperheroPersistenceAdapter superheroPersistenceAdapter;

    @Mock
    SuperheroRepository superheroRepository;

    @Mock
    private EntityManager entityManager;

    private final SuperheroMapper superheroMapper = Mappers.getMapper(SuperheroMapper.class);

    @Test
    void testGetAll() {
        when(superheroRepository.findAll()).thenReturn(Arrays.asList(Mockito.mock(SuperheroEntity.class)));

        assertNotNull(superheroPersistenceAdapter.getAll());
    }

    @Test
    void testGetById() {
        long superheroId = 1L;
        when(superheroRepository.findById(superheroId)).thenReturn(Optional.of(Mockito.mock(SuperheroEntity.class)));

        assertNotNull(superheroPersistenceAdapter.getById(superheroId));
    }

    @Test
    void testCreate() {
        when(superheroRepository.save(any())).thenReturn(Mockito.mock(SuperheroEntity.class));

        superheroPersistenceAdapter.create(new SuperheroEntity());

        verify(superheroRepository, times(1)).save(any());
    }

    @Test
    void testModify() {
        when(superheroRepository.findById(1L)).thenReturn(Optional.of(new SuperheroEntity(1L, "Spiderman", "Peter Parker",
                Arrays.asList("Web-slinging"), LocalDate.of(1990, 1, 1),
                LocalDate.of(1990, 1, 1), 1.80, 68.5, "Avengers",

                "Marvel", true, "No")));

        superheroPersistenceAdapter.modify(new SuperheroEntity(1L, "Spiderman", "Peter Parker",
                Arrays.asList("Web-slinging"), LocalDate.of(1990, 1, 1),
                LocalDate.of(1990, 1, 1), 1.80, 68.5, "Avengers",
                "Marvel", true, "No"));

        verify(superheroRepository, times(1)).save(any());
    }

    @Test
    void testDelete() {
        when(superheroRepository.findById(1L)).thenReturn(Optional.of(new SuperheroEntity(1L, "Spiderman", "Peter Parker",
                Arrays.asList("Web-slinging"), LocalDate.of(1990, 1, 1),
                LocalDate.of(1990, 1, 1), 1.80, 68.5, "Avengers",

                "Marvel", true, "No")));

        assertDoesNotThrow(() -> superheroPersistenceAdapter.delete(1L), "Divide should not throw an exception");

        verify(superheroRepository, times(1)).findById(any());
    }
}
