package com.viagem.services;

import java.util.List;

import com.viagem.model.entity.Compra;

public interface CompraService {

	Compra saveCompra(Compra compra);

	List<Compra> getAllCompras();

	Compra getCompraById(long id);

	Compra updateCompra(Compra compra, long id);

	void deleteCompra(long id);

}
