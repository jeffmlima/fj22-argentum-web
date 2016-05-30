package br.com.caelum.argentum.testes;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;

public class TestaWebService {

	public static void main(String[] args) {
		System.out.println(carregaNegociacoesTeste()/*new ClienteWebService().getNegociacoes()*/);

	}
	
	private static List<Negociacao> carregaNegociacoesTeste(){
		String xmlDeTeste = "<list>" +
				"<negociacao>" +
				"<preco>43.5</preco>" +
				"<quantidade>1000</quantidade>" +
				"<data>" +
				"<time>1322233344455</time>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>50.5</preco>" +
				"<quantidade>1000</quantidade>" +
				"<data>" +
				"<time>1322233344400</time>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>55.5</preco>" +
				"<quantidade>1000</quantidade>" +
				"<data>" +
				"<time>1322233344460</time>" +
				"</data>" +
				"</negociacao>" +
				"</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream inputStream = new ByteArrayInputStream(xmlDeTeste.getBytes());
		return leitor.carrega(inputStream);
	}

}
