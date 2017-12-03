package br.com.cyborg.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.cyborg.enums.PessoaType;

@XmlRootElement
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 2391962686440107345L;
	
	private Long id;
	private String nome;
	private PessoaType tipo;
	private Endereco endereco;
	
	public Pessoa() {
	}

	public Pessoa(Long id, String nome, PessoaType tipo, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.endereco = endereco;
	}

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

	
	public PessoaType getTipo() {
		return tipo;
	}


	public void setTipo(PessoaType tipo) {
		this.tipo = tipo;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	} 

	
}
