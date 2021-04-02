package com.dh.cantina.service;

import org.springframework.stereotype.Service;

import com.dh.cantina.model.Telefone;
import com.dh.cantina.repository.TelefoneRepository;
@Service
public class TelefoneService {

	private TelefoneRepository telefoneRepository;
	
	
	public TelefoneService(TelefoneRepository telefoneRepository) {
		this.telefoneRepository = telefoneRepository;
	}


	public void salvar(Telefone telefone) {
		telefoneRepository.save(telefone);
	}

}
