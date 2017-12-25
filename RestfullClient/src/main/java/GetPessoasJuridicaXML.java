import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

public class GetPessoasJuridicaXML {

	public static void main(String[] args) {
		
		for (Pessoa pessoa : ClientWS.getPessoasTipo(MediaType.APPLICATION_XML,PessoaType.J.getValor()).getPessoas()) {
			System.out.println(pessoa.toString());
		}
	}

}
