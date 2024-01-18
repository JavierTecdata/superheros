package com.w2m.superheros.application.ports.output;

import com.w2m.superheros.domain.entity.SuperheroEntity;

import java.util.List;

/**
 * Output Port: Superhero
 *
 * Description: Defines the interactions with the database.
 *
 * @author Javier Sánchez González
 */
public interface SuperheroOutputPort {

    /**
     * Get All Superheros
     *
     * @author Javier Sánchez González
     * @return List of SuperheroEntity
     */
    List<SuperheroEntity> getAll();

    /**
     * Get Superhero by Id
     *
     * @param id long
     * @author Javier Sánchez González
     * @return SuperheroEntity
     */
    SuperheroEntity getById(Long id);

    /**
     * Search Superhero by Name
     *
     * @param name String
     * @author Javier Sánchez González
     * @return List of SuperheroEntity
     */
    List<SuperheroEntity> searchByName(String name);

    /**
     * Create Superhero
     *
     * @param superheroEntity SuperheroEntity
     * @author Javier Sánchez González
     * @return SuperheroEntity
     */
    SuperheroEntity create(SuperheroEntity superheroEntity);

    /**
     * Modify Superhero
     *
     * @param superheroEntity SuperheroEntity
     * @author Javier Sánchez González
     * @return SuperheroEntity
     */
    SuperheroEntity modify(SuperheroEntity superheroEntity);

    /**
     * Delete Superhero
     *
     * @param id long
     * @author Javier Sánchez González
     * @return SuperheroEntity
     */
    SuperheroEntity delete(Long id);
}
