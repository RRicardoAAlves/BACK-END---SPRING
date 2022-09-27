package com.viagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viagem.model.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
