import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.entity.Pessoas;
import br.com.cyborg.enums.PessoaType;

public class AddPessoasXML {

	public static void main(String[] args) {
		
		Pessoas pessoas = new Pessoas();
		pessoas.getPessoas().add(new Pessoa(10L, "pessoa10", PessoaType.F, new Endereco(10L, "rua10", 10L) ));
		pessoas.getPessoas().add(new Pessoa(11L, "pessoa11", PessoaType.J, new Endereco(11L, "rua11", 11L) ));
		
		System.out.println( ClientWS.addPessoas( MediaType.APPLICATION_XML, pessoas) );
		
	}

}
