import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Pessoa;

public class GetPessoasXML {

	public static void main(String[] args) {
		
		for (Pessoa pessoa : ClientWS.getPessoasXML().getPessoas()) {
			System.out.println(pessoa.toString());
		}
	}

}
