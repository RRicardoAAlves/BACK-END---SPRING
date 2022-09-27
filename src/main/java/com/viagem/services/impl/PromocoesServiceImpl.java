package com.viagem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.model.entity.Promocoes;
import com.viagem.repositories.PromocoesRepository;
import com.viagem.services.PromocoesService;
import com.viagem.exception.ResourceNotFoundException;

@Service
public class PromocoesServiceImpl implements PromocoesService {

	@Autowired
	private PromocoesRepository promocoesRepository;

	@Override
	public Promocoes savePromocoes(Promocoes promocoes) {
		return promocoesRepository.save(promocoes);
	}

	@Override
	public List<Promocoes> getAllPromocoes() {
		return promocoesRepository.findAll();
	}

	@Override
	public Promocoes getPromocoesById(long id) {
		return promocoesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Promoções", "id", id));
	}

	@Override
	public Promocoes updatePromocoes(Promocoes promocoes, long id) {
		Promocoes promocoesExistente = promocoesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Promoções", "id", id));

		promocoesExistente.setDestino_promocao(promocoes.getDestino_promocao());
		promocoesExistente.setPreco_promocao(promocoes.getPreco_promocao());

		promocoesRepository.save(promocoesExistente);
		return promocoesExistente;
	}

	@Override
	public void deletePromocoes(long id) {
		promocoesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Promoções", "id", id));

		promocoesRepository.deleteById(id);

	}

}
