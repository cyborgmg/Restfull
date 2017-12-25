import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Pessoa;

public class GetPessoaJSON {

	public static void main(String[] args) {
		
		System.out.println(ClientWS.getPessoaJSON(0L).toString());
		
	}

}
