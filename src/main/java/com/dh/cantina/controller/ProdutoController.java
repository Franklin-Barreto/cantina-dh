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

import com.dh.cantina.model.Produto;
import com.dh.cantina.model.input.ProdutoInput;
import com.dh.cantina.service.ProdutoService;

@RestController
@RequestMapping("produto")
public class ProdutoController {

	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody ProdutoInput produtoInput, UriComponentsBuilder uriBuilder) {
		Produto produto = this.produtoService.salvar(produtoInput);
		URI uri = uriBuilder.path("produto/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(produto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Produto produto = produtoService.findById(id);
	//	produto.getCategoria();
		return ResponseEntity.ok(produto);
	}
}
