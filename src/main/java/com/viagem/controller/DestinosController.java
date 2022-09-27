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

import com.viagem.model.entity.Destinos;
import com.viagem.services.impl.DestinosServiceImpl;

@RestController
@RequestMapping("api/destino")
public class DestinosController {

	@Autowired
	private DestinosServiceImpl service;

	@GetMapping("/destinos")
	public String helloWorld() {
		return "OI-3";

	}

	@GetMapping
	public ResponseEntity<List<Destinos>> findAll() {
		List<Destinos> destino = service.getAllDestinos();
		return ResponseEntity.ok().body(destino);
	}

	@GetMapping("{id}")
	public ResponseEntity<Destinos> getDestinosById(@PathVariable("id") long DestinosId) {
		return new ResponseEntity<Destinos>(service.getDestinosById(DestinosId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Destinos> saveDestinos(@RequestBody Destinos destinos) {
		return new ResponseEntity<Destinos>(service.saveDestinos(destinos), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Destinos> updateDestinos(@PathVariable("id") long id, @RequestBody Destinos destinos) {
		return new ResponseEntity<Destinos>(service.updateDestinos(destinos, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDestinos(@PathVariable("id") long id) {
		service.deleteDestinos(id);

		return new ResponseEntity<String>("Destino deletado com sucesso.", HttpStatus.OK);
	}

}
