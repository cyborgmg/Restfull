import br.com.cyborg.client.ClientWS;
import br.com.cyborg.entity.Pessoa;

public class GetPessoaXML {

	public static void main(String[] args) {
		
		System.out.println(ClientWS.getPessoaXML(0L).toString());
		
	}

}
