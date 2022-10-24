package com.viagem.model.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acessos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Acesso {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nome_acesso;

	public Acesso(Long id) {
		this.id = id;
	}

}
