package com.dh.cantina.service;

import org.springframework.stereotype.Service;

import com.dh.cantina.model.Categoria;
import com.dh.cantina.repository.CategoriaRepository;

@Service
public class CategoriaService {

	private CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public Categoria salvar(String categoria) {
		return this.categoriaRepository.save(new Categoria(categoria));
	}

	public Categoria findyById(Integer categoria) {
		return categoriaRepository.getOne(categoria);
	}
}
