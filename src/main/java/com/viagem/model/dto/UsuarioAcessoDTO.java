package com.viagem.model.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioAcessoDTO {

	public Long idUsuario;

	public List<Long> idsAcesso;

}
