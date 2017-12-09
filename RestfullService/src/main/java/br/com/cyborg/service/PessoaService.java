package br.com.cyborg.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import br.com.cyborg.dao.PessoaDao;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/pessoa")
public class PessoaService {
	
	@Inject
	private PessoaDao pessoaDao;

	@GET
	@Path("/pessoas")
	@Produces(MediaType.APPLICATION_XML)	
	public List<Pessoa> getPessoas() {

	    return pessoaDao.getAll();
	}
	
	@GET
	@Path("/pessoas/{tipo}")
	@Produces(MediaType.APPLICATION_XML)	
	public List<Pessoa> getPessoas(@PathParam("tipo") String valor) {

	    return pessoaDao.getPessoaTypes(PessoaType.getPessoaType(valor));
	}
	
	@POST
    @Path("/addPessoa")
    @Consumes(MediaType.APPLICATION_XML)
	public Response addPessoa(Pessoa pessoa){
		pessoaDao.addPessoa(pessoa);
		return Response.status(200).build();
	}
	
	@DELETE
    @Path("/delPessoa")
    @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response delPessoa(Pessoa pessoa){
		if(pessoaDao.delPessoa(pessoa)){
			return Response.status(200).build();
		}else{
			return Response.status(417).entity("Pessoa não existe").build();
		}
	}

}