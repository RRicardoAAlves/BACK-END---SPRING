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

import com.viagem.model.entity.Promocoes;
import com.viagem.services.impl.PromocoesServiceImpl;

@RestController
@RequestMapping("api/promocao")
public class PromocoesController {

	@Autowired
	private PromocoesServiceImpl service;

	@GetMapping("/promocoes")
	public String helloWorld() {
		return "OI-4";

	}

	@GetMapping
	public ResponseEntity<List<Promocoes>> findAll() {
		List<Promocoes> promocao = service.getAllPromocoes();
		return ResponseEntity.ok().body(promocao);
	}

	@GetMapping("{id}")
	public ResponseEntity<Promocoes> getPromocoesById(@PathVariable("id") long PromocoesId) {
		return new ResponseEntity<Promocoes>(service.getPromocoesById(PromocoesId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Promocoes> savePromocoes(@RequestBody Promocoes promocoes) {
		return new ResponseEntity<Promocoes>(service.savePromocoes(promocoes), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Promocoes> updatePromocoes(@PathVariable("id") long id, @RequestBody Promocoes promocoes) {
		return new ResponseEntity<Promocoes>(service.updatePromocoes(promocoes, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePromocoes(@PathVariable("id") long id) {
		service.deletePromocoes(id);

		return new ResponseEntity<String>("Promoção deletada com sucesso.", HttpStatus.OK);
	}

}
