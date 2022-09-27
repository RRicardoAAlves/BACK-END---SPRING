package com.viagem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.model.entity.Compra;
import com.viagem.repositories.CompraRepository;
import com.viagem.services.CompraService;
import com.viagem.exception.ResourceNotFoundException;

@Service
public class CompraServiceImpl implements CompraService {

	@Autowired
	private CompraRepository compraRepository;

	@Override
	public Compra saveCompra(Compra compra) {
		return compraRepository.save(compra);
	}

	@Override
	public List<Compra> getAllCompras() {
		return compraRepository.findAll();
	}

	@Override
	public Compra getCompraById(long id) {
		return compraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Compra", "id", id));
	}

	@Override
	public Compra updateCompra(Compra compra, long id) {
		Compra compraExistente = compraRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Compra", "id", id));

		compraExistente.setCheckIn(compra.getCheckIn());
		compraExistente.setCheckOut(compra.getCheckOut());
		compraExistente.setCliente(compra.getCliente());
		compraExistente.setDestinos(compra.getDestinos());
		compraExistente.setPromocoes(compra.getPromocoes());

		compraRepository.save(compraExistente);
		return compraExistente;
	}

	@Override
	public void deleteCompra(long id) {
		compraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Compra", "id", id));

		compraRepository.deleteById(id);

	}

}
