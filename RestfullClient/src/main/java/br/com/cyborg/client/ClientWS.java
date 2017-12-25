package br.com.cyborg.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.entity.Pessoas;


public class ClientWS {
	
	static class Constats{
		public static String uri="http://127.0.0.1:8080/RestfullService/rest";
		public static String username="admin";
		public static String password="admin";
	}
	
	static class PessoaPaths{
		private static final String pessoa = "/pessoa";
		public static final String pessoaId = pessoa+"/pessoa";
		public static final String pessoas = pessoa+"/pessoas";
		public static final String pessoasTipo = pessoa+"/pessoas";
		public static final String addPessoa = pessoa+"/addPessoa";
		public static final String addPessoas = pessoa+"/addPessoas";
		public static final String updPessoa = pessoa+"/updPessoa";
		public static final String updPessoas = pessoa+"/updPessoas";
		public static final String delPessoa = pessoa+"/delPessoa";
		public static final String delPessoas = pessoa+"/delPessoas";
	}
	
	public static WebResource getWebResource() {
		Client client = Client.create();		
		client.addFilter(new HTTPBasicAuthFilter(Constats.username,Constats.password));
		return client.resource(Constats.uri);
	}
	
	/***********************************GET****************************************************************/
	
	public static Pessoa getPessoaXML(Long id) {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.pessoaId+"/"+id).accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		
		return response.getEntity(Pessoa.class);
	}
	
	public static Pessoa getPessoaJSON(Long id) {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.pessoaId+"/"+id).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		
		return response.getEntity(Pessoa.class);
	}
	
	public static Pessoas getPessoasXML() {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.pessoas).accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		
		return response.getEntity(Pessoas.class);
	}

	public static Pessoas getPessoasJSON() {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.pessoas).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		
		return response.getEntity(Pessoas.class);
	}
	
	public static Pessoas getPessoasTipo(String accept, String tipo) {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.pessoasTipo+"/"+tipo).accept(accept).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		
		return response.getEntity(Pessoas.class);
	}
	
	/***********************************POST***************************************************************/
	
	public static int addPessoa(String accept, Pessoa pessoa) {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.addPessoa).type(accept).post(ClientResponse.class,pessoa);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		
		return response.getStatus();
	}
	
	public static int addPessoas(String accept, Pessoas pessoas) {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.addPessoas).type(accept).post(ClientResponse.class,pessoas);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		
		return response.getStatus();
	}
	
	/***********************************PUT****************************************************************/

	public static int updPessoa(String accept, Pessoa pessoa) {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.updPessoa).type(accept).put(ClientResponse.class,pessoa);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		
		return response.getStatus();
	}
	
	public static Pessoas updPessoas(String accept, Pessoas pessoas) {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.updPessoas).type(accept).put(ClientResponse.class,pessoas);
		
		System.out.println(response.getStatus());
		
		return response.getEntity(Pessoas.class);
	}
	
	/***********************************DEL****************************************************************/

	public static int delPessoa(String accept, Pessoa pessoa) {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.delPessoa).type(accept).delete(ClientResponse.class,pessoa);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		
		return response.getStatus();
	}
	
	public static Pessoas delPessoas(String accept, Pessoas pessoas) {
		
		ClientResponse response = ClientWS.getWebResource().path(PessoaPaths.delPessoas).type(accept).delete(ClientResponse.class,pessoas);
		
		System.out.println(response.getStatus());
		
		return response.getEntity(Pessoas.class);
	}
	
}
