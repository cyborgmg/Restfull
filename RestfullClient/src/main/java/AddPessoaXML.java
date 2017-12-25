import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

public class AddPessoaXML {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa(8L, "pessoa08", PessoaType.F, new Endereco(8L, "rua08", 8L) );
		
		System.out.println( ClientWS.addPessoa( MediaType.APPLICATION_XML, pessoa) );
		
	}

}
