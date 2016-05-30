package br.com.caelum.argentum.mb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.reader.LeitorXML;

@ManagedBean @ViewScoped
public class ArgentumBean implements Serializable {
	
	private static final long serialVersionUID = -6252488051256710494L;
	
	private List<Negociacao> negociacoes;
	private String indicadorBase;
	private String media;
	private ChartModel modeloGrafico = new LineChartModel();
	
	public ArgentumBean() {
		this.negociacoes = carregaNegociacoesTeste()/*new ClienteWebService().getNegociacoes()*/;
		List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
		geradorGrafico.plotaMediaMovelSimples();
		this.modeloGrafico = geradorGrafico.getChartModel();
	}

	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}
	
	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}
	
	private List<Negociacao> carregaNegociacoesTeste(){
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
