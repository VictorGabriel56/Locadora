package br.com.locadora.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.Usuario;
import br.com.locadora.repository.filtros.FiltroUsuario;

@Repository
public interface ClienteRepository {

List<Usuario> findByNomeContaining(String filtro);
	
	List<Cliente> findAll();

	Cliente save(Cliente cliente);

	void delete(Long id);

	Usuario findOne(FiltroUsuario filtro);

	void saveAndFlush(Cliente cliente);


	
}
