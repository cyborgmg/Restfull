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
		pessoas.add(new Pessoa(0L, "pessoa00", PessoaType.F, new Endereco(0L, "rua00", 0L)));
		pessoas.add(new Pessoa(1L, "pessoa01", PessoaType.J, new Endereco(1L, "rua01", 1L)));
		pessoas.add(new Pessoa(2L, "pessoa02", PessoaType.F, new Endereco(2L, "rua02", 2L)));
		pessoas.add(new Pessoa(3L, "pessoa03", PessoaType.J, new Endereco(3L, "rua03", 3L)));
		pessoas.add(new Pessoa(4L, "pessoa04", PessoaType.F, new Endereco(4L, "rua04", 4L)));
		pessoas.add(new Pessoa(5L, "pessoa05", PessoaType.J, new Endereco(5L, "rua05", 5L)));
		pessoas.add(new Pessoa(6L, "pessoa06", PessoaType.J, new Endereco(6L, "rua06", 6L)));
		pessoas.add(new Pessoa(7L, "pessoa07", PessoaType.J, new Endereco(7L, "rua07", 7L)));
		
		logger.info("Lista carregada com "+pessoas.size()+" registros");
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
}
