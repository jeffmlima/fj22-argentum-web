package br.com.caelum.argentum.mb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.IndicadorFactory;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.reader.LeitorXML;

@ManagedBean @ViewScoped
public class ArgentumBean {
	
	private List<Negociacao> negociacoes;
	private String indicadorBase;
	private String media;
	private ChartModel modeloGrafico = new LineChartModel();
	
	public ArgentumBean() {
		this.negociacoes = carregaNegociacoesTeste()/*new ClienteWebService().getNegociacoes()*/;
		geraGrafico();
	}

	public void geraGrafico() {
		System.out.println("Plotando: "+ media + " de "+indicadorBase);
		List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
//		geradorGrafico.plotaMediaMovelSimples();
//		geradorGrafico.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento(), 3));
//		geradorGrafico.plotaIndicador(defineIndicador());
		geradorGrafico.plotaIndicador(new IndicadorFactory(media, indicadorBase).defineIndicador());
		this.modeloGrafico = geradorGrafico.getChartModel();
	}

	/*private Indicador defineIndicador() {
		if (indicadorBase == null || media == null)
			return new MediaMovelSimples(new IndicadorFechamento(), 3);
		try {
			String pacote = "br.com.caelum.argentum.indicadores.";
			Class<?> classeIndicadorBase = Class.forName(pacote+indicadorBase);
			Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();
			
			Class<?> classeMedia = Class.forName(pacote+media);
			Constructor<?> constructorMedia = classeMedia.getConstructor(Indicador.class, int.class);
			Indicador indicador = (Indicador) constructorMedia.newInstance(indicadorBase, 3);
			return indicador;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/

	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}
	
	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}
	
	public String getIndicadorBase() {
		return indicadorBase;
	}
	
	public void setIndicadorBase(String indicadorBase) {
		this.indicadorBase = indicadorBase;
	}
	
	public String getMedia() {
		return media;
	}
	
	public void setMedia(String media) {
		this.media = media;
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
