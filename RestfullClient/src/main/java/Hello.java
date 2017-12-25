import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.ClientResponse;

import br.com.cyborg.client.ClientWS;

public class Hello {

  public static void main(String[] args) {
	try {

		ClientResponse response = ClientWS.getWebResource().path("/hello/rodrigo").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		
		System.out.println(response.getEntity(String.class));

	  } catch (Exception e) {

		e.printStackTrace();

	  }

	}
}