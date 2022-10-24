package com.viagem.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.viagem.model.entity.Usuario;

import com.viagem.repositories.UsuarioRepository;
import com.viagem.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private BCryptPasswordEncoder passwordEncoder() { 
		  return new BCryptPasswordEncoder();
	  }

	
	public Usuario saveUsuario(Usuario usuario) {

		Usuario existsUsuario = usuarioRepository.findByUsername(usuario.getUsername());

		if (existsUsuario != null) {
			throw new Error("Nome de usuário já existe!!!");
		}
		
		usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));
		
		Usuario usuarioCriado = usuarioRepository.save(usuario);

		return usuarioCriado;
	}

	
}
