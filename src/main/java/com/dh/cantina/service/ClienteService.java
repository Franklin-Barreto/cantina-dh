package com.dh.cantina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.cantina.model.Cliente;
import com.dh.cantina.model.Telefone;
import com.dh.cantina.model.input.ClienteInput;
import com.dh.cantina.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;
	private TelefoneService telefoneService;
	@Autowired
	public ClienteService(ClienteRepository clienteRepository,TelefoneService telefoneService) {
		this.clienteRepository = clienteRepository;
		this.telefoneService = telefoneService;
	}

	public Cliente salvar(ClienteInput clienteInput) {
		Cliente cliente = this.clienteRepository.save(new Cliente(clienteInput.getNome()));
		telefoneService.salvar(Telefone.of(clienteInput.getDdd(), clienteInput.getNumero(),cliente));
		return cliente;
	}

	public Cliente findById(Long cliente) {

		//return this.clienteRepository.findById(cliente).orElseThrow(RuntimeException::new);
		return this.clienteRepository.getOne(cliente);
	}
}
