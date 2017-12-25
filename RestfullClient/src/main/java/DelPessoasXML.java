import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Endereco;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.entity.Pessoas;
import br.com.cyborg.enums.PessoaType;

public class DelPessoasXML {

	public static void main(String[] args) {
		
		Pessoas pessoas = new Pessoas();
		pessoas.getPessoas().add(new Pessoa(3L));
		pessoas.getPessoas().add(new Pessoa(4L));
		
		for (Pessoa pessoa : ClientWS.delPessoas( MediaType.APPLICATION_XML, pessoas).getPessoas()) {
			System.out.println("não encontrou a pessoa id="+pessoa.getId());
		}
		
	}

}
