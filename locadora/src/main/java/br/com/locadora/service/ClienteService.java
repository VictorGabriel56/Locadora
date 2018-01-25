package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.Usuario;
import br.com.locadora.repository.ClienteRepository;
import br.com.locadora.repository.filtros.FiltroUsuario;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
	
	public Usuario findOne(FiltroUsuario filtro) {
		return this.clienteRepository.findOne(filtro);
	}
	
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public void remove(Long id) {
		this.clienteRepository.delete(id);
	}
	
	public void edit(Cliente cliente) {
		this.clienteRepository.saveAndFlush(cliente);
	}
	
	public void remover(Long idCliente) {
		this.clienteRepository.delete(idCliente);
	}
	
}
