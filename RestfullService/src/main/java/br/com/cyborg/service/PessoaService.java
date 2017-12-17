package br.com.cyborg.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.ArrayUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

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
		
		return Response.status(pessoaDao.addPessoas(pessoas.getPessoa())?200:406).build();
	}
	
	@DELETE
    @Path("/delPessoa")
    @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response delPessoa(Pessoa pessoa){
		if(pessoaDao.delPessoa(pessoa)){
			return Response.status(200).build();
		}else{
			return Response.status(404).entity("Pessoa não existe").build();
		}
	}
	
	@DELETE
    @Path("/delPessoas")
    @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response delPessoas(List<Pessoa> pessoas){
		
		List<Long> ids = pessoaDao.delPessoas(pessoas);
		
		StringBuilder xml = new StringBuilder("<pessoas>");
		
		for (Long id : ids) {
			xml.append("<pessoa>");
			xml.append("<id>"+id+"</id>");
			xml.append("</pessoa>");
		}
		
		xml.append("</pessoas>");
			
		if(ids.size()==0){
			return Response.status(200).build();
		}else{
			return Response.status(404).entity(xml.toString()).build();
		}
	}

}