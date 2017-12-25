import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

public class UpdPessoaJSON {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa(2L, "pessoa222", PessoaType.J, new Endereco(222L, "rua222", 222L) );
		
		System.out.println( ClientWS.updPessoa( MediaType.APPLICATION_JSON, pessoa) );
		
	}

}
