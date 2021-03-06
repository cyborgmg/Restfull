package br.com.cyborg.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pessoas")
public class Pessoas implements Serializable {

	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public Pessoas() {
		super();
	}

	public Pessoas(List<Pessoa> pessoas) {
		super();
		this.pessoas = pessoas;
	}

	@XmlElement(name = "pessoa")
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
}
