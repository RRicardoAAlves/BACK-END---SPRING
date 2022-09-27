package com.viagem.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compra")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "check_in")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate checkIn;

	@Column(name = "check_out")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate checkOut;

	@JoinColumn(name = "id_cliente")
	@ManyToOne
	private Cliente cliente;

	@JoinColumn(name = "id_destinos")
	@ManyToOne
	private Destinos destinos;

	@JoinColumn(name = "id_promocoes")
	@ManyToOne
	private Promocoes promocoes;

}
