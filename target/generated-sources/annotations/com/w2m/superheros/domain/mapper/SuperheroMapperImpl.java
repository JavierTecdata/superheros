package com.w2m.superheros.domain.mapper;

import com.w2m.superheros.domain.dto.SuperheroDto;
import com.w2m.superheros.domain.entity.SuperheroEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-18T01:58:13+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class SuperheroMapperImpl implements SuperheroMapper {

    @Override
    public SuperheroDto toDto(SuperheroEntity superheroEntity) {
        if ( superheroEntity == null ) {
            return null;
        }

        SuperheroDto superheroDto = new SuperheroDto();

        superheroDto.setId( superheroEntity.getId() );
        superheroDto.setName( superheroEntity.getName() );
        superheroDto.setAlias( superheroEntity.getAlias() );
        List<String> list = superheroEntity.getPowers();
        if ( list != null ) {
            superheroDto.setPowers( new ArrayList<String>( list ) );
        }
        superheroDto.setCreatedAt( superheroEntity.getCreatedAt() );
        superheroDto.setLastModification( superheroEntity.getLastModification() );
        superheroDto.setHeight( superheroEntity.getHeight() );
        superheroDto.setWeight( superheroEntity.getWeight() );
        superheroDto.setTeam( superheroEntity.getTeam() );
        superheroDto.setPublisher( superheroEntity.getPublisher() );
        superheroDto.setVillain( superheroEntity.isVillain() );
        superheroDto.setMainWeapon( superheroEntity.getMainWeapon() );

        return superheroDto;
    }

    @Override
    public SuperheroEntity toEntity(SuperheroDto superheroDto) {
        if ( superheroDto == null ) {
            return null;
        }

        SuperheroEntity superheroEntity = new SuperheroEntity();

        superheroEntity.setId( superheroDto.getId() );
        superheroEntity.setName( superheroDto.getName() );
        superheroEntity.setAlias( superheroDto.getAlias() );
        List<String> list = superheroDto.getPowers();
        if ( list != null ) {
            superheroEntity.setPowers( new ArrayList<String>( list ) );
        }
        superheroEntity.setCreatedAt( superheroDto.getCreatedAt() );
        superheroEntity.setLastModification( superheroDto.getLastModification() );
        superheroEntity.setHeight( superheroDto.getHeight() );
        superheroEntity.setWeight( superheroDto.getWeight() );
        superheroEntity.setTeam( superheroDto.getTeam() );
        superheroEntity.setPublisher( superheroDto.getPublisher() );
        superheroEntity.setVillain( superheroDto.isVillain() );
        superheroEntity.setMainWeapon( superheroDto.getMainWeapon() );

        return superheroEntity;
    }
}
