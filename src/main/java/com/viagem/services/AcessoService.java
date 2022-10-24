package com.viagem.services;

import com.viagem.model.dto.UsuarioAcessoDTO;
import com.viagem.model.entity.Usuario;

public interface AcessoService {
	
	Usuario executar(UsuarioAcessoDTO usuarioAcessoDTO);

}
