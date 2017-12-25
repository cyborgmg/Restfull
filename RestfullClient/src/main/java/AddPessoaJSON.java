import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

public class AddPessoaJSON {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa(9L, "pessoa09", PessoaType.J, new Endereco(9L, "rua09", 9L) );
		
		System.out.println( ClientWS.addPessoa( MediaType.APPLICATION_JSON, pessoa) );
		
	}

}
