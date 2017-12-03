package br.com.cyborg.service;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.cyborg.dao.PessoaDao;
import br.com.cyborg.entity.Pessoa;

import javax.ws.rs.core.MediaType;

@Path("/pessoa")
public class PessoaService {

	@GET
	@Path("/pessoas")
	@Produces(MediaType.APPLICATION_XML)	
	public List<Pessoa> getPessoas() {

	    return (new PessoaDao()).getAll();
	}

}