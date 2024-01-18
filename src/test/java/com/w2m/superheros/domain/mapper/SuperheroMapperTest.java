package com.w2m.superheros.domain.mapper;

import com.w2m.superheros.domain.dto.SuperheroDto;
import com.w2m.superheros.domain.entity.SuperheroEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SuperheroMapperTest {

    private SuperheroMapper superheroMapper = Mappers.getMapper(SuperheroMapper.class);

    @Test
    void testToDto() {
        SuperheroEntity entity = new SuperheroEntity(1L, "Spiderman", "Peter Parker",
                Arrays.asList("Web-slinging"), LocalDate.of(1990, 1, 1),
                LocalDate.of(1990, 1, 1), 1.80, 68.5, "Avengers",
                "Marvel", true, "No");

        SuperheroDto dto = superheroMapper.toDto(entity);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(entity.getId());
        assertThat(dto.getName()).isEqualTo(entity.getName());
        assertThat(dto.getAlias()).isEqualTo(entity.getAlias());
        assertThat(dto.getPowers()).isEqualTo(entity.getPowers());
        assertThat(dto.getCreatedAt()).isEqualTo(entity.getCreatedAt());
        assertThat(dto.getLastModification()).isEqualTo(entity.getLastModification());
        assertThat(dto.getHeight()).isEqualTo(entity.getHeight());
        assertThat(dto.getWeight()).isEqualTo(entity.getWeight());
        assertThat(dto.getTeam()).isEqualTo(entity.getTeam());
        assertThat(dto.getPublisher()).isEqualTo(entity.getPublisher());
        assertThat(dto.isVillain()).isEqualTo(entity.isVillain());
        assertThat(dto.getMainWeapon()).isEqualTo(entity.getMainWeapon());
    }

    @Test
    void testToEntity() {
        SuperheroDto dto = new SuperheroDto(1L, "Spiderman", "Peter Parker",
                Arrays.asList("Web-slinging"), LocalDate.of(1990, 1, 1),
                LocalDate.of(1990, 1, 1), 1.80, 68.5, "Avengers",
                "Marvel", true, "No");

        SuperheroEntity entity = superheroMapper.toEntity(dto);

        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isEqualTo(dto.getId());
        assertThat(entity.getName()).isEqualTo(dto.getName());
        assertThat(entity.getAlias()).isEqualTo(dto.getAlias());
        assertThat(entity.getPowers()).isEqualTo(dto.getPowers());
        assertThat(entity.getCreatedAt()).isEqualTo(dto.getCreatedAt());
        assertThat(entity.getLastModification()).isEqualTo(dto.getLastModification());
        assertThat(entity.getHeight()).isEqualTo(dto.getHeight());
        assertThat(entity.getWeight()).isEqualTo(dto.getWeight());
        assertThat(entity.getTeam()).isEqualTo(dto.getTeam());
        assertThat(entity.getPublisher()).isEqualTo(dto.getPublisher());
        assertThat(entity.isVillain()).isEqualTo(dto.isVillain());
        assertThat(entity.getMainWeapon()).isEqualTo(dto.getMainWeapon());
    }

    @Test
    void testToDto_NullInput() {
        assertThat(superheroMapper.toDto(null)).isNull();
    }

    @Test
    void testToEntity_NullInput() {
        assertThat(superheroMapper.toEntity(null)).isNull();
    }
}
