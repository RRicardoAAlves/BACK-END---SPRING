package com.viagem.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "promocoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Promocoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "destino_promocao")
	private String destino_promocao;

	@Column(name = "preco_promocao")
	private BigDecimal preco_promocao;

}
