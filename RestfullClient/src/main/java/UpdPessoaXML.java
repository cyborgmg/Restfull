import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

public class UpdPessoaXML {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa(1L, "pessoa111", PessoaType.F, new Endereco(111L, "rua111", 111L) );
		
		System.out.println( ClientWS.updPessoa( MediaType.APPLICATION_XML, pessoa) );
		
	}

}
