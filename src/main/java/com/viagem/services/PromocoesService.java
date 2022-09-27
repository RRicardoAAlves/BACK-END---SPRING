package com.viagem.services;

import java.util.List;

import com.viagem.model.entity.Promocoes;

public interface PromocoesService {

	Promocoes savePromocoes(Promocoes promocoes);

	List<Promocoes> getAllPromocoes();

	Promocoes getPromocoesById(long id);

	Promocoes updatePromocoes(Promocoes promocoes, long id);

	void deletePromocoes(long id);

}
