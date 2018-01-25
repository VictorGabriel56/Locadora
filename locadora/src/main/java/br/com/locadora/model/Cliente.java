package br.com.locadora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Cliente implements Serializable{

	@Id
	private Long id;
	
	@Column(nullable = false, length = 200)
	@NotBlank(message = "Nome é informação obrigatória.")
	private String nome;
	
	@Column(nullable = false, length = 200)
	@NotBlank(message = "Email é informação obrigatória.")
	private String email;
	
	@Column(nullable = false, length = 200)
	@NotBlank(message = "Telefone é informação obrigatória.")
	private Long telefone;
	
	@Column(nullable = false, length = 200)
	@NotBlank(message = "CPF é informação obrigatória.")
	private Long cpf;
	
	
		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
}
