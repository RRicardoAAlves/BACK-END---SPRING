package com.viagem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.model.entity.Destinos;
import com.viagem.repositories.DestinosRepository;
import com.viagem.services.DestinosService;
import com.viagem.exception.ResourceNotFoundException;

@Service
public class DestinosServiceImpl implements DestinosService {

	@Autowired
	private DestinosRepository destinosRepository;

	@Override
	public Destinos saveDestinos(Destinos destinos) {
		return destinosRepository.save(destinos);
	}

	@Override
	public List<Destinos> getAllDestinos() {
		return destinosRepository.findAll();
	}

	@Override
	public Destinos getDestinosById(long id) {
		return destinosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destinos", "id", id));
	}

	@Override
	public Destinos updateDestinos(Destinos destinos, long id) {
		Destinos destinosExistente = destinosRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Destinos", "id", id));

		destinosExistente.setDestino(destinos.getDestino());
		destinosExistente.setPreco(destinos.getPreco());

		destinosRepository.save(destinosExistente);
		return destinosExistente;
	}

	@Override
	public void deleteDestinos(long id) {
		destinosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destinos", "id", id));

		destinosRepository.deleteById(id);

	}

}
