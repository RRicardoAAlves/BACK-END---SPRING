package com.viagem.services;

import java.util.List;

import com.viagem.model.entity.Destinos;

public interface DestinosService {

	Destinos saveDestinos(Destinos destinos);

	List<Destinos> getAllDestinos();

	Destinos getDestinosById(long id);

	Destinos updateDestinos(Destinos destinos, long id);

	void deleteDestinos(long id);

}
