import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.entity.Pessoas;
import br.com.cyborg.enums.PessoaType;

public class AddPessoasJSON {

	public static void main(String[] args) {
		
		Pessoas pessoas = new Pessoas();
		pessoas.getPessoas().add(new Pessoa(12L, "pessoa12", PessoaType.F, new Endereco(12L, "rua12", 12L) ));
		pessoas.getPessoas().add(new Pessoa(13L, "pessoa13", PessoaType.J, new Endereco(13L, "rua13", 13L) ));
		
		System.out.println( ClientWS.addPessoas( MediaType.APPLICATION_JSON, pessoas) );
		
	}

}
