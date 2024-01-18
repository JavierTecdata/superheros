package com.w2m.superheros.infrastructure.adapters.input.rest;

import com.w2m.superheros.domain.dto.SuperheroDto;
import com.w2m.superheros.domain.mapper.SuperheroMapper;
import com.w2m.superheros.domain.service.SuperheroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SuperheroRestAdapterTest {

    @InjectMocks
    SuperheroRestAdapter superheroRestAdapter;

    @Mock
    SuperheroService superheroService;

    private final SuperheroMapper superheroMapper = Mappers.getMapper(SuperheroMapper.class);

    @Test
    void testGetAll() {
        when(superheroService.getAll()).thenReturn(Arrays.asList(Mockito.mock(SuperheroDto.class)));

        assertNotNull(superheroRestAdapter.getAll().getBody());
    }

    @Test
    void testGetById() {
        String superheroId = "1";
        when(superheroService.getById(Long.valueOf(superheroId))).thenReturn(Mockito.mock(SuperheroDto.class));

        assertNotNull(superheroRestAdapter.getById(superheroId).getBody());
    }

    @Test
    void testSearchByName() {
        String name = "Thor";
        when(superheroService.searchByName(name)).thenReturn(Arrays.asList(Mockito.mock(SuperheroDto.class)));

        assertNotNull(superheroRestAdapter.searchByName(name).getBody());
    }

    @Test
    void testCreate() {
        when(superheroService.create(Mockito.any())).thenReturn(Mockito.mock(SuperheroDto.class));

        superheroRestAdapter.create(new SuperheroDto());

        verify(superheroService, times(1)).create(Mockito.any());
    }

    @Test
    void testModify() {
        when(superheroService.modify(Mockito.any())).thenReturn(Mockito.mock(SuperheroDto.class));

        superheroRestAdapter.modify(new SuperheroDto());

        verify(superheroService, times(1)).modify(Mockito.any());
    }

    @Test
    void testDelete() {
        when(superheroService.delete(Mockito.any())).thenReturn(Mockito.mock(SuperheroDto.class));

        superheroRestAdapter.delete("1");

        verify(superheroService, times(1)).delete(Mockito.any());
    }
}
