package com.viagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viagem.model.dto.UsuarioAcessoDTO;
import com.viagem.model.entity.Usuario;
import com.viagem.services.AcessoService;
import com.viagem.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	AcessoService acessoService;

	@PostMapping("/create")
	public Usuario save(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);

	}

	@PostMapping("/acesso")
	public Usuario acesso(@RequestBody UsuarioAcessoDTO usuarioAcessoDTO) {
		return acessoService.executar(usuarioAcessoDTO);

	}

}
