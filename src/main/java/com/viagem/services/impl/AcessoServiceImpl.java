package com.viagem.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.model.dto.UsuarioAcessoDTO;
import com.viagem.model.entity.Acesso;

import com.viagem.model.entity.Usuario;

import com.viagem.repositories.UsuarioRepository;
import com.viagem.services.AcessoService;

@Service
public class AcessoServiceImpl implements AcessoService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Usuario executar(UsuarioAcessoDTO usuarioAcessoDTO) {

		Optional<Usuario> usuarioExists = usuarioRepository.findById(usuarioAcessoDTO.idUsuario);
		List<Acesso> acessos = new ArrayList<>();

		if (usuarioExists.isEmpty()) {
			throw new Error("Usuário não encontrado.");
		}

		acessos = usuarioAcessoDTO.getIdsAcesso().stream().map(acesso -> {
			return new Acesso(acesso);
		}).collect(Collectors.toList());

		Usuario usuario = usuarioExists.get();

		usuario.setAcessos(acessos);

		usuarioRepository.save(usuario);

		return usuario;
	}

}
