package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.locadora.model.Cliente;
import br.com.locadora.repository.ClienteRepository;


@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listar(){
		return this.clienteRepository.findAll();
	}
	
	public Cliente search(Long id) {
		return this.clienteRepository.findOne(id);
	}

	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public void delete(Long id) {
		this.clienteRepository.delete(id);
	}
	
	public void remove(Long id) {
		this.clienteRepository.delete(id);
	}
}
