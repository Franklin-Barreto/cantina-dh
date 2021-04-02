package com.dh.cantina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.cantina.model.Cliente;
import com.dh.cantina.model.ItemPedido;
import com.dh.cantina.model.Pedido;
import com.dh.cantina.model.input.PedidoInput;
import com.dh.cantina.repository.PedidoRepository;

@Service
public class PedidoService {

	private ClienteService clienteService;
	private PedidoRepository pedidoRepository;
	private ItemService itemService;

	@Autowired
	public PedidoService(ClienteService clienteService, PedidoRepository pedidoRepository, ItemService itemService) {
		this.clienteService = clienteService;
		this.pedidoRepository = pedidoRepository;
		this.itemService = itemService;
	}

	public Pedido salvar(PedidoInput pedidoInput) {
		Cliente cliente = clienteService.findById(pedidoInput.getCliente());
		Pedido pedido = this.pedidoRepository.save(new Pedido(cliente));
		List<ItemPedido> itens = itemService.salvar(pedidoInput.getItens(), pedido);
		pedido.setItens(itens);
		return pedido;
	}
}
