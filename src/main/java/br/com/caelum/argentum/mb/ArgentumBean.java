package br.com.caelum.argentum.mb;

import java.util.List;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

public class ArgentumBean {
	
	private List<Negociacao> negociacoes;
	
	public ArgentumBean() {
		this.negociacoes = new ClienteWebService().getNegociacoes();
	}

	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}

}
