package com.w2m.superheros.domain.service;

import com.w2m.superheros.domain.dto.SuperheroDto;
import com.w2m.superheros.domain.entity.SuperheroEntity;
import com.w2m.superheros.domain.mapper.SuperheroMapper;
import com.w2m.superheros.infrastructure.adapters.output.persistence.SuperheroPersistenceAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SuperheroServiceTest {

    @InjectMocks
    SuperheroService superheroService;

    @Mock
    SuperheroPersistenceAdapter superheroPersistenceAdapter;

    private final SuperheroMapper superheroMapper = Mappers.getMapper(SuperheroMapper.class);

    @Test
    void testGetAll() {
        when(superheroPersistenceAdapter.getAll()).thenReturn(Arrays.asList(Mockito.mock(SuperheroEntity.class)));

        List<SuperheroDto> result = superheroService.getAll();

        assertEquals(1, result.size());
    }

    @Test
    void testGetById() {
        long superheroId = 1L;
        when(superheroPersistenceAdapter.getById(superheroId)).thenReturn(Mockito.mock(SuperheroEntity.class));

        SuperheroDto result = superheroService.getById(superheroId);

        assertNotNull(result);
    }

    @Test
    void testSearchByName() {
        String name = "Thor";
        when(superheroPersistenceAdapter.searchByName(name)).thenReturn(Arrays.asList(Mockito.mock(SuperheroEntity.class)));

        List<SuperheroDto> result = superheroService.searchByName(name);

        assertEquals(1, result.size());
    }

    @Test
    void testCreate() {
        when(superheroPersistenceAdapter.create(Mockito.any())).thenReturn(Mockito.mock(SuperheroEntity.class));

        superheroService.create(new SuperheroDto());

        verify(superheroPersistenceAdapter, times(1)).create(Mockito.any());
    }

    @Test
    void testModify() {
        when(superheroPersistenceAdapter.modify(Mockito.any())).thenReturn(Mockito.mock(SuperheroEntity.class));

        superheroService.modify(new SuperheroDto());

        verify(superheroPersistenceAdapter, times(1)).modify(Mockito.any());
    }

    @Test
    void testDelete() {
        when(superheroPersistenceAdapter.delete(Mockito.any())).thenReturn(Mockito.mock(SuperheroEntity.class));

        superheroService.delete(1L);

        verify(superheroPersistenceAdapter, times(1)).delete(Mockito.any());
    }
}
