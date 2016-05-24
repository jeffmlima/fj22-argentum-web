package br.com.caelum.argentum.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {
	
	private static final long serialVersionUID = -6252488051256710494L;
	
	private List<Negociacao> negociacoes;
	
	public ArgentumBean() {
		this.negociacoes = new ClienteWebService().getNegociacoes();
	}

	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}

}
