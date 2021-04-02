package com.dh.cantina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.cantina.model.Categoria;
import com.dh.cantina.model.Produto;
import com.dh.cantina.model.input.ProdutoInput;
import com.dh.cantina.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	private CategoriaService categoriaService;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository, CategoriaService categoriaService) {
		this.produtoRepository = produtoRepository;
		this.categoriaService = categoriaService;
	}

	public Produto findById(Long produto) {

		return produtoRepository.getOne(produto);
	}

	public Produto salvar(ProdutoInput produtoInput) {
		Categoria categoria = categoriaService.findyById(produtoInput.getCategoria());
		return produtoRepository.save(new Produto(produtoInput.getDescricao(), produtoInput.getPreco(), categoria));
	}
}
