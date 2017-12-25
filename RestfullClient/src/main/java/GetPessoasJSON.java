import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Pessoa;

public class GetPessoasJSON {

	public static void main(String[] args) {
		
		for (Pessoa pessoa : ClientWS.getPessoasJSON().getPessoas()) {
			System.out.println(pessoa.toString());
		}
	}

}
