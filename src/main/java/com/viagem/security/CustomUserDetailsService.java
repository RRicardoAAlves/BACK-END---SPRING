package com.viagem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.viagem.model.entity.Usuario;
import com.viagem.repositories.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsernameFetchAcessos(username);
		if (usuario == null)
			usuario = usuarioRepository.findByUsername(username);
		if (usuario == null)
			throw new Error("Usuario inexistente");
		return new UsuarioPrincipal(usuario);
	}
}
