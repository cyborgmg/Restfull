import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

public class DelPessoaJSON {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa(1L);
		
		System.out.println( ClientWS.delPessoa( MediaType.APPLICATION_JSON, pessoa) );
		
	}

}
