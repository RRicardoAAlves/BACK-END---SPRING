package com.viagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viagem.model.entity.Cliente;
import com.viagem.services.impl.ClienteServiceImpl;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl service;

	@GetMapping("/cliente")
	public String helloWorld() {
		return "OI-2";
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = service.getAllClientes();
		return ResponseEntity.ok().body(clientes);
	}

	@GetMapping("{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("id") long ClienteId) {
		return new ResponseEntity<Cliente>(service.getClienteById(ClienteId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(service.saveCliente(cliente), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(service.updateCliente(cliente, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCliente(@PathVariable("id") long id) {
		service.deleteCliente(id);

		return new ResponseEntity<String>("Cliente deletado com sucesso.", HttpStatus.OK);
	}

}
