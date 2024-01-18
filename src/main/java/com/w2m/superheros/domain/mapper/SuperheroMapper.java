package com.w2m.superheros.domain.mapper;

import com.w2m.superheros.domain.dto.SuperheroDto;
import com.w2m.superheros.domain.entity.SuperheroEntity;
import org.mapstruct.Mapper;

/**
 * Superhero Mapper
 *
 * Description: Mapper for Superhero Objects
 *
 * @author Javier Sánchez González
 */
@Mapper
public interface SuperheroMapper {

    /**
     * Entity to Dto Mapper
     *
     * @author Javier Sánchez González
     * @param superheroEntity SuperheroEntity
     * @return SuperheroDto
     */
    SuperheroDto toDto(SuperheroEntity superheroEntity);

    /**
     * Dto to Entity Mapper
     *
     * @author Javier Sánchez González
     * @param superheroDto SuperheroDto
     * @return SuperheroEntity
     */
    SuperheroEntity toEntity(SuperheroDto superheroDto);

}
