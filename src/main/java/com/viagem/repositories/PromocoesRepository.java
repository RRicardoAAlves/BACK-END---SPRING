package com.viagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viagem.model.entity.Promocoes;

@Repository
public interface PromocoesRepository extends JpaRepository<Promocoes, Long> {

}
