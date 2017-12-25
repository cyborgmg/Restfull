import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.entity.Pessoas;
import br.com.cyborg.enums.PessoaType;

public class UpdPessoasJSON {

	public static void main(String[] args) {
		
		Pessoas pessoas = new Pessoas();
		pessoas.getPessoas().add(new Pessoa(5L, "pessoa555", PessoaType.F, new Endereco(555L, "rua555", 555L) ));
		pessoas.getPessoas().add(new Pessoa(6L, "pessoa666", PessoaType.J, new Endereco(666L, "rua666", 666L) ));
		pessoas.getPessoas().add(new Pessoa(1000L, "pessoa1000", PessoaType.J, new Endereco(1000L, "rua1000", 1000L) ));
		
		for (Pessoa pessoa : ClientWS.updPessoas( MediaType.APPLICATION_JSON, pessoas).getPessoas()) {
			System.out.println("não encontrou a pessoa id="+pessoa.getId());
		}
		
	}

}
