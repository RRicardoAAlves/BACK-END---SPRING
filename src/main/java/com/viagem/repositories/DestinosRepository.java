package com.viagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viagem.model.entity.Destinos;

@Repository
public interface DestinosRepository extends JpaRepository<Destinos, Long> {

}
