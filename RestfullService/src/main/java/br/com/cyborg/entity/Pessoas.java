package br.com.cyborg.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pessoas")
public class Pessoas implements Serializable {

	
	private List<Pessoa> pessoa = new ArrayList<Pessoa>();

	public Pessoas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Pessoas(List<Pessoa> pessoa) {
		super();
		this.pessoa = pessoa;
	}



	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	
}
