package br.com.cyborg.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.cyborg.enums.PessoaType;

@XmlRootElement(name="pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 2391962686440107345L;
	
	
	private Long id;
	
	private String nome;
	
	private PessoaType tipo;
	
	private Endereco endereco;
	
	public Pessoa() {
	}

	public Pessoa(Long id) {
		super();
		this.id = id;
	}
	
	public Pessoa(Long id, String nome, PessoaType tipo, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.endereco = endereco;
	}

	@XmlAttribute
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	@XmlAttribute
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlAttribute
	public PessoaType getTipo() {
		return tipo;
	}


	public void setTipo(PessoaType tipo) {
		this.tipo = tipo;
	}

	@XmlElement
	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", endereco=" + endereco.toString() + "]";
	} 

	
}
