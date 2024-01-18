package com.w2m.superheros.infrastructure.adapters.output.persistence;

import com.w2m.superheros.application.ports.output.SuperheroOutputPort;
import com.w2m.superheros.domain.entity.SuperheroEntity;
import com.w2m.superheros.infrastructure.adapters.output.persistence.repository.SuperheroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SuperheroPersistenceAdapter implements SuperheroOutputPort {

    private final SuperheroRepository repository;

    private EntityManager entityManager;

    @Autowired
    public SuperheroPersistenceAdapter(SuperheroRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public List<SuperheroEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public SuperheroEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException("SuperheroEntity not found for id: " + id, 1));
    }

    @Override
    public List<SuperheroEntity> searchByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SuperheroEntity> query = criteriaBuilder.createQuery(SuperheroEntity.class);
        Root<SuperheroEntity> root = query.from(SuperheroEntity.class);

        Predicate namePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
        query.where(namePredicate);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public SuperheroEntity create(SuperheroEntity superheroEntity) {
        superheroEntity.setCreatedAt(LocalDate.now());
        superheroEntity = repository.save(superheroEntity);
        return superheroEntity;
    }

    @Override
    @Transactional
    public SuperheroEntity modify(SuperheroEntity superheroEntity) {
        Long id = superheroEntity.getId();
        Objects.requireNonNull(id, "Superhero entity ID cannot be null");

        Optional<SuperheroEntity> optionalSuperhero = repository.findById(id);
        optionalSuperhero.orElseThrow(() ->
                new EntityNotFoundException("The Superhero entity does not exist in the database with ID: " + id));

        try {
            repository.save(superheroEntity);
            return superheroEntity;
        } catch (DataAccessException ex) {
            throw new EmptyResultDataAccessException("Error when deleting the Superhero entity with ID: " + id, 1);
        }
    }

    @Override
    @Transactional
    public SuperheroEntity delete(Long id) {
        Objects.requireNonNull(id, "Superhero entity ID cannot be null");

        Optional<SuperheroEntity> optionalSuperhero = repository.findById(id);
        SuperheroEntity superheroEntity = optionalSuperhero.orElseThrow(() ->
                new EntityNotFoundException("The Superhero entity does not exist in the database with ID: " + id));

        try {
            repository.deleteById(id);
            return superheroEntity;
        } catch (DataAccessException ex) {
            throw new EmptyResultDataAccessException("Error when deleting the Superhero entity with ID: " + id, 1);
        }
    }
}
