package com.viagem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.model.entity.Cliente;
import com.viagem.repositories.ClienteRepository;
import com.viagem.services.ClienteService;
import com.viagem.exception.ResourceNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getClienteById(long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));
	}

	@Override
	public Cliente updateCliente(Cliente cliente, long id) {
		Cliente clienteExistente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));

		clienteExistente.setTipo_pessoa(cliente.getTipo_pessoa());
		clienteExistente.setNome(cliente.getNome());
		clienteExistente.setCpf_cnpj(cliente.getCpf_cnpj());
		clienteExistente.setEndereco(cliente.getEndereco());
		clienteExistente.setCidade(cliente.getCidade());
		clienteExistente.setUf_estado(cliente.getUf_estado());
		clienteExistente.setTelefone(cliente.getTelefone());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setMensagem(cliente.getMensagem());

		clienteRepository.save(clienteExistente);
		return clienteExistente;
	}

	@Override
	public void deleteCliente(long id) {
		clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));

		clienteRepository.deleteById(id);

	}

}
