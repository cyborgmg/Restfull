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
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.cyborg.dao.PessoaDao;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

@Path("/pessoa")
public class PessoaService {

	@Inject
	private PessoaDao pessoaDao;
	
	@GET
	@Path("/pessoas")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})	
	public Response getPessoas() {

		XStream xstream = new XStream();
		//xstream.alias("pessoas", List.class);
		//xstream.alias("pessoa", Pessoa.class);
		
		String xml = xstream.toXML(pessoaDao.getAll());
		
		//String json = new Gson().toJson(pessoaDao.getAll());
		
		return Response.status(200).type(MediaType.APPLICATION_XML).entity(xml).build();
	}
	
/*
	@GET
	@Path("/pessoas")
	@Produces(MediaType.APPLICATION_XML)	
	public List<Pessoa> getPessoas() {

		return pessoaDao.getAll();
	}
*/
	/*
	@GET
	@Path("/pessoas")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getPessoas(@HeaderParam("accept") String format) {
		
	*/
		/*
		if(format.equals("json")){
			return Response.status(200).type(MediaType.APPLICATION_JSON).entity(pessoaDao.getAll()).build();
	    } else {
	    	return Response.status(200).type(MediaType.APPLICATION_XML).entity(pessoaDao.getAll()).build();
	    }
		*/
		
		
		//GenericEntity<List<Pessoa>> entity = new GenericEntity<List<Pessoa>>(pessoaDao.getAll()) {};
/*		
		return Response.status(200).type(MediaType.APPLICATION_XML).entity(pessoaDao.getAll()).build();
	}

*/	
	/* 
	 
	  return Response.ok().entity(new GenericEntity<List<Cliente>>(cliente) {
	}).build();
	 
	@GET
	@Path("/pessoas")
	//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	public Response getPessoas(@HeaderParam("accept") String format) {

		return Response.status(200).type(MediaType.APPLICATION_JSON).entity(pessoaDao.getAll()).build();
	}
*/	
	@GET
	@Path("/pessoas/{type}/{tipo}")
	@Produces(MediaType.APPLICATION_XML)	
	public List<Pessoa> getPessoas(@PathParam("type") String type, @PathParam("tipo") String valor) {

	    return pessoaDao.getPessoaTypes(PessoaType.getPessoaType(valor));
	}
	
	@POST
    @Path("/addPessoa")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    //@Consumes(MediaType.APPLICATION_XML)
	public Response addPessoa(Pessoa pessoa){
		pessoaDao.addPessoa(pessoa);
		return Response.status(200).build();
	}
	
	@POST
    @Path("/addPessoas")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    //@Consumes(MediaType.APPLICATION_XML)
	public Response addPessoas(List<Pessoa> pessoas){
		pessoaDao.addPessoas(pessoas);
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