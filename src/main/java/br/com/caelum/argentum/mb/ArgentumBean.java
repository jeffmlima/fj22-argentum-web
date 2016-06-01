package br.com.caelum.argentum.mb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.reader.LeitorXML;

@ManagedBean @ViewScoped
public class ArgentumBean {
	
	private List<Negociacao> negociacoes;
//	private String indicadorBase;
//	private String media;
	private ChartModel modeloGrafico = new LineChartModel();
	
	public ArgentumBean() {
		this.negociacoes = carregaNegociacoesTeste()/*new ClienteWebService().getNegociacoes()*/;
		List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
//		geradorGrafico.plotaMediaMovelSimples();
		geradorGrafico.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento(), 3));
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
				"<preco>289.57</preco>" +
				"<quantidade>17</quantidade>" +
				"<data>" +
				"<time>1459382400000</time>" +
				"<timezone>Etc/UTC</timezone>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>241.94</preco>" +
				"<quantidade>14</quantidade>" +
				"<data>" +
				"<time>1459382400000</time>" +
				"<timezone>Etc/UTC</timezone>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>332.19</preco>" +
				"<quantidade>19</quantidade>" +
				"<data>" +
				"<time>1459382400000</time>" +
				"<timezone>Etc/UTC</timezone>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>325.06</preco>" +
				"<quantidade>19</quantidade>" +
				"<data>" +
				"<time>1459382400000</time>" +
				"<timezone>Etc/UTC</timezone>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>150.6</preco>" +
				"<quantidade>19</quantidade>" +
				"<data>" +
				"<time>1459555200000</time>" +
				"<timezone>Etc/UTC</timezone>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>254.06</preco>" +
				"<quantidade>19</quantidade>" +
				"<data>" +
				"<time>1459555200000</time>" +
				"<timezone>Etc/UTC</timezone>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>645.06</preco>" +
				"<quantidade>19</quantidade>" +
				"<data>" +
				"<time>1459555200000</time>" +
				"<timezone>Etc/UTC</timezone>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>55.06</preco>" +
				"<quantidade>19</quantidade>" +
				"<data>" +
				"<time>1459641600000</time>" +
				"<timezone>Etc/UTC</timezone>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>585.06</preco>" +
				"<quantidade>19</quantidade>" +
				"<data>" +
				"<time>1459641600000</time>" +
				"<timezone>Etc/UTC</timezone>" +
				"</data>" +
				"</negociacao>" +
				"<negociacao>" +
				"<preco>498.06</preco>" +
				"<quantidade>19</quantidade>" +
				"<data>" +
				"<time>1459641600000</time>" +
				"<timezone>Etc/UTC</timezone>" +
				"</data>" +
				"</negociacao>" +
				"</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream inputStream = new ByteArrayInputStream(xmlDeTeste.getBytes());
		return leitor.carrega(inputStream);
	}

}
