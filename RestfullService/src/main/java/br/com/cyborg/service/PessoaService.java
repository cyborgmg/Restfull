package br.com.cyborg.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.ArrayUtils;

import br.com.cyborg.dao.PessoaDao;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.entity.Pessoas;
import br.com.cyborg.enums.PessoaType;

@Path("/pessoa")
public class PessoaService {

	String[] apis = { MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML };
	
	@Inject
	private PessoaDao pessoaDao;
	
	@GET
	@Path("/pessoas")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})	
	public Response getPessoas(@Context HttpHeaders headers) {
		
		String accept = headers.getRequestHeader("Accept").get(0);
		
		return Response.status(200).type(ArrayUtils.contains( apis, accept )?accept:MediaType.APPLICATION_XML).entity(pessoaDao.getAll()).build();
	}
	
	@GET
	@Path("/pessoa/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})	
	public Response getPessoas(@HeaderParam("Accept") String accept, @PathParam("id") Long id) {
		
		Pessoa pessoa = pessoaDao.getPessoa(id);
		if(pessoa!=null){
			return Response.status(200).type(ArrayUtils.contains( apis, accept )?accept:MediaType.APPLICATION_XML).entity(pessoa).build();
		}else{
			return Response.status(404).type(ArrayUtils.contains( apis, accept )?accept:MediaType.APPLICATION_XML).entity("Pessoa não encontrada").build();
		}
	}
	
	
	@GET
	@Path("/pessoas/{tipo}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getPessoas(@Context HttpHeaders headers, String type, @PathParam("tipo") String tipo) {

		String accept = headers.getRequestHeader("Accept").get(0);
		
		return Response.status(200).type(ArrayUtils.contains( apis, accept )?accept:MediaType.APPLICATION_XML)
				.entity(pessoaDao.getPessoaTypes(PessoaType.getPessoaType(tipo))).build();
	    
	}
	
	@POST
    @Path("/addPessoa")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response addPessoa(Pessoa pessoa){
		
		pessoaDao.addPessoa(pessoa);
		return Response.status(200).build();
	}
	
	@POST
    @Path("/addPessoas")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response addPessoas(Pessoas pessoas){
		
		return Response.status(pessoaDao.addPessoas(pessoas.getPessoas())?200:406).build();
	}
	
	@PUT
    @Path("/updPessoa")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response updPessoa(Pessoa pessoa){
		
		if(pessoaDao.updPessoa(pessoa)){
			return Response.status(200).build();
		}else{
			return Response.status(404).entity("Pessoa não existe").build();
		}
	}
	
	@PUT
    @Path("/updPessoas")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response updPessoas(@Context HttpHeaders headers, Pessoas pessoas){
		
		pessoas.setPessoas( pessoaDao.updPessoas(pessoas.getPessoas()) );
		
		String contentType = headers.getRequestHeader("Content-Type").get(0);
		
		if(pessoas.getPessoas().size()==0){
			return Response.status(200).build();
		}else{
			return Response.status(404).type(ArrayUtils.contains( apis, contentType )?contentType:MediaType.APPLICATION_XML)
					.entity(pessoas).build();
		}
	}
	
	@DELETE
    @Path("/delPessoa")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response delPessoa(Pessoa pessoa){
		if(pessoaDao.delPessoa(pessoa)){
			return Response.status(200).build();
		}else{
			return Response.status(404).entity("Pessoa não existe").build();
		}
	}
	
	@DELETE
    @Path("/delPessoas")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response delPessoas(@Context HttpHeaders headers, Pessoas pessoas){
		
		pessoas.setPessoas( pessoaDao.delPessoas(pessoas.getPessoas()) );
		
		String contentType = headers.getRequestHeader("Content-Type").get(0);
		
		if(pessoas.getPessoas().size()==0){
			return Response.status(200).build();
		}else{
			return Response.status(404).type(ArrayUtils.contains( apis, contentType )?contentType:MediaType.APPLICATION_XML)
					.entity(pessoas).build();
		}
	}

}