package com.viagem.model.entity;



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
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_pessoa")
	private String tipo_pessoa;

	@Column
	private String nome;

	@Column
	private String cpf_cnpj;

	@Column
	private String endereco;

	@Column
	private String cidade;

	@Column
	private String uf_estado;

	@Column
	private String telefone;

	@Column
	private String email;

	@Column
	private String mensagem;
	
	
	
}
