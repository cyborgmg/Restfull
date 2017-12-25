import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.entity.Pessoas;
import br.com.cyborg.enums.PessoaType;

public class UpdPessoasXML {

	public static void main(String[] args) {
		
		Pessoas pessoas = new Pessoas();
		pessoas.getPessoas().add(new Pessoa(3L, "pessoa333", PessoaType.F, new Endereco(333L, "rua333", 333L) ));
		pessoas.getPessoas().add(new Pessoa(4L, "pessoa444", PessoaType.J, new Endereco(444L, "rua444", 444L) ));
		pessoas.getPessoas().add(new Pessoa(1000L, "pessoa1000", PessoaType.J, new Endereco(1000L, "rua1000", 1000L) ));
		
		for (Pessoa pessoa : ClientWS.updPessoas( MediaType.APPLICATION_XML, pessoas).getPessoas()) {
			System.out.println("não encontrou a pessoa id="+pessoa.getId());
		}
		
	}

}
