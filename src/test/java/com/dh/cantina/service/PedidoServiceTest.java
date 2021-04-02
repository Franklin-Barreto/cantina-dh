package com.dh.cantina.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.dh.cantina.model.Pedido;
import com.dh.cantina.model.input.ItemPedidoInput;
import com.dh.cantina.model.input.PedidoInput;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PedidoServiceTest {

	@Autowired
	private PedidoService pedidoService;
	
	@Test
	public void salvarPedido() {
	
		List<ItemPedidoInput> itens = new ArrayList<>();
		itens.add(new ItemPedidoInput(1L, 3));
		itens.add(new ItemPedidoInput(2L, 2));
		Pedido pedido = this.pedidoService.salvar(new PedidoInput(1L,itens));
		assertEquals(1L, pedido.getId());
		assertEquals("Franklin Barreto",pedido.getCliente().getNome());
		System.out.println("Caiu aqui mano 2"+pedido.getCliente().getId());
	}
}
