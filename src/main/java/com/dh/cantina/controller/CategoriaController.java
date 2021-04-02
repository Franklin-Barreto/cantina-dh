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

import com.dh.cantina.model.Categoria;
import com.dh.cantina.service.CategoriaService;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

	private CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping
	public ResponseEntity<Categoria> salvar(@RequestBody String descricao, UriComponentsBuilder uriBuilder) {
		Categoria categoria = categoriaService.salvar(descricao);
		URI uri = uriBuilder.path("categoria/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(categoria);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(categoriaService.findyById(id));
	}
}
