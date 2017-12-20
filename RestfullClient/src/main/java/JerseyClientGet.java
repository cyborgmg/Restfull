import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class JerseyClientGet {

  public static void main(String[] args) {
	try {
		
		String baseUrl="http://127.0.0.1:8080/RestfullService/rest/hello/rodrigo";
		String username="admin";
		String password="admin";		
		
		Client client = Client.create();
		
		client.addFilter(new HTTPBasicAuthFilter(username,password));

		WebResource webResource = client.resource(baseUrl);
		
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output);

	  } catch (Exception e) {

		e.printStackTrace();

	  }

	}
}