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

import com.viagem.model.entity.Compra;

import com.viagem.services.impl.CompraServiceImpl;

@RestController
@RequestMapping("api/compras")
public class CompraController {

	@Autowired
	private CompraServiceImpl service;

	@GetMapping("/compra")
	public String helloWorld() {
		return "OI";
	}

	@GetMapping
	public ResponseEntity<List<Compra>> findAll() {
		List<Compra> compra = service.getAllCompras();
		return ResponseEntity.ok().body(compra);
	}

	@GetMapping("{id}")
	public ResponseEntity<Compra> getDestinosById(@PathVariable("id") long CompraId) {
		return new ResponseEntity<Compra>(service.getCompraById(CompraId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Compra> saveCompra(@RequestBody Compra compra) {
		return new ResponseEntity<Compra>(service.saveCompra(compra), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Compra> updateCompra(@PathVariable("id") long id, @RequestBody Compra compra) {
		return new ResponseEntity<Compra>(service.updateCompra(compra, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCompra(@PathVariable("id") long id) {
		service.deleteCompra(id);

		return new ResponseEntity<String>("Compra deletada com sucesso.", HttpStatus.OK);
	}

}
