package com.dh.cantina.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dh.cantina.model.Cliente;
import com.dh.cantina.model.input.ClienteInput;
import com.dh.cantina.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody ClienteInput clienteInput, UriComponentsBuilder uriBuilder) {

		Cliente cliente = this.clienteService.salvar(clienteInput);
		URI uri = uriBuilder.path("cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(clienteService.findById(id));
	}

}
