package br.com.cyborg.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

public class PessoaDao {
	
	public List<Pessoa> getAll(){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(new Pessoa(0L, "pessoa01", PessoaType.F, new Endereco(0L, "rua01", 1l)));
		pessoas.add(new Pessoa(1L, "pessoa02", PessoaType.J, new Endereco(1L, "rua02", 2l)));
		pessoas.add(new Pessoa(2L, "pessoa03", PessoaType.F, new Endereco(2L, "rua03", 3l)));
		pessoas.add(new Pessoa(3L, "pessoa04", PessoaType.J, new Endereco(3L, "rua04", 4l)));
		pessoas.add(new Pessoa(4L, "pessoa05", PessoaType.F, new Endereco(4L, "rua05", 5l)));
		pessoas.add(new Pessoa(5L, "pessoa06", PessoaType.J, new Endereco(5L, "rua06", 6l)));
		
		return pessoas;
	}
}
