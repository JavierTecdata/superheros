package com.w2m.superheros.infrastructure.adapters.output.persistence.repository;

import com.w2m.superheros.domain.entity.SuperheroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperheroRepository extends JpaRepository<SuperheroEntity, Long> {
}
