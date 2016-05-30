package br.com.caelum.argentum.reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
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
		List<Negociacao> negociacoes = leitor.carrega(inputStream);
		assertEquals(1, negociacoes.size());
		assertEquals(43.5, negociacoes.get(0).getPreco(), 0.0001);
		assertEquals(1000, negociacoes.get(0).getQuantidade());
	}
	
	@Test
	public void carregaXmlComZeroNegociacao(){
		String xmlDeTeste = "<list>" +
				"</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream inputStream = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(inputStream);
		assertEquals(0, negociacoes.size());
	}

}
