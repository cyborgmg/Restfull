import javax.ws.rs.core.MediaType;

import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

public class GetPessoasFisicaJSON {

	public static void main(String[] args) {
		
		for (Pessoa pessoa : ClientWS.getPessoasTipo(MediaType.APPLICATION_JSON,PessoaType.F.getValor()).getPessoas()) {
			System.out.println(pessoa.toString());
		}
	}

}
