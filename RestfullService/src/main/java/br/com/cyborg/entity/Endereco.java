package br.com.cyborg.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Endereco implements Serializable {

	private static final long serialVersionUID = -1715694549746670849L;
	
	private Long id;
	private String rua;
	private Long numero;
	
	
	
	public Endereco() {
	}

	public Endereco(Long id, String rua, Long numero) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	
}
