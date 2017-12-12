package br.com.cyborg.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

@Startup
@Singleton
@Named("aplicationBean")
@TransactionManagement(TransactionManagementType.BEAN)
public class AplicationBean implements Serializable {
	
	private static final long serialVersionUID = 7341039890343063436L;

	Logger logger = Logger.getLogger(AplicationBean.class);
	
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	@PostConstruct
	private void init(){
		pessoas.add(new Pessoa(0L, "pessoa01", PessoaType.F, new Endereco(0L, "rua01", 1l)));
		pessoas.add(new Pessoa(1L, "pessoa02", PessoaType.J, new Endereco(1L, "rua02", 2l)));
		pessoas.add(new Pessoa(2L, "pessoa03", PessoaType.F, new Endereco(2L, "rua03", 3l)));
		pessoas.add(new Pessoa(3L, "pessoa04", PessoaType.J, new Endereco(3L, "rua04", 4l)));
		pessoas.add(new Pessoa(4L, "pessoa05", PessoaType.F, new Endereco(4L, "rua05", 5l)));
		pessoas.add(new Pessoa(5L, "pessoa06", PessoaType.J, new Endereco(5L, "rua06", 6l)));
		
		logger.info("Lista carregada com "+pessoas.size()+" registros");
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
}
