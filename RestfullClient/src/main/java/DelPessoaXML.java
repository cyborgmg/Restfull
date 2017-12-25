import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

public class DelPessoaXML {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa(0L);
		
		System.out.println( ClientWS.delPessoa( MediaType.APPLICATION_XML, pessoa) );
		
	}

}
