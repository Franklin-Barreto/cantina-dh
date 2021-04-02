package com.dh.cantina.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dh.cantina.model.ItemPedido;
import com.dh.cantina.model.Pedido;
import com.dh.cantina.model.Produto;
import com.dh.cantina.model.input.ItemPedidoInput;
import com.dh.cantina.repository.ItemRepository;

@Service
public class ItemService {

	private ItemRepository itemRepository;
	private ProdutoService produtoService;
	
	public ItemService(ItemRepository itemRepository,ProdutoService produtoService) {
		this.itemRepository = itemRepository;
		this.produtoService = produtoService;
	}
	
	public List<ItemPedido> salvar(List<ItemPedidoInput> itensPedidoInput,Pedido pedido){
		
		List<ItemPedido> itensPedido = itensPedidoInput.stream().map(item->{
			Produto produto = produtoService.findById(item.getProduto());
			return new ItemPedido(produto, produto.getPreco(), item.getQuantidade(),pedido);
		}).collect(Collectors.toList());
		return this.itemRepository.saveAll(itensPedido);
	}
}
