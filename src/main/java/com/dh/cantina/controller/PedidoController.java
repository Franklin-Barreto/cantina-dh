package com.dh.cantina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.cantina.model.Pedido;
import com.dh.cantina.model.input.PedidoInput;
import com.dh.cantina.service.PedidoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {

	private PedidoService pedidoService;

	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@PostMapping
	public ResponseEntity<Pedido> salvar(@RequestBody PedidoInput pedidoInput) {
		Pedido pedido = pedidoService.salvar(pedidoInput);
		System.out.println("Deu certo"+pedido.getCliente().getNome());
		return ResponseEntity.ok(pedido);
	}
}
