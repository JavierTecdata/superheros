package com.w2m.superheros.application.ports.input;

import com.w2m.superheros.domain.dto.SuperheroDto;

import java.util.List;

/**
 * Use Case: Superhero
 *
 * Description: Defines basic CRUD operations for superheroes.
 *
 * @author Javier Sánchez González
 */
public interface SuperheroUseCase {

    /**
     * Get All Superheros
     *
     * @author Javier Sánchez González
     * @return List of SuperheroDto
     */
    List<SuperheroDto> getAll();

    /**
     * Get Superhero by Id
     *
     * @param id long
     * @author Javier Sánchez González
     * @return SuperheroDto
     */
    SuperheroDto getById(Long id);

    /**
     * Search Superhero by Name
     *
     * @param name String
     * @author Javier Sánchez González
     * @return List of SuperheroDto
     */
    List<SuperheroDto> searchByName(String name);

    /**
     * Create Superhero
     *
     * @param superheroDto SuperheroDto
     * @author Javier Sánchez González
     * @return SuperheroDto
     */
    SuperheroDto create(SuperheroDto superheroDto);

    /**
     * Modify Superhero
     *
     * @param superheroDto SuperheroDto
     * @author Javier Sánchez González
     * @return SuperheroDto
     */
    SuperheroDto modify(SuperheroDto superheroDto);

    /**
     * Delete Superhero
     *
     * @param id long
     * @author Javier Sánchez González
     * @return SuperheroDto
     */
    SuperheroDto delete(Long id);

}
