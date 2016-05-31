package br.com.caelum.argentum.grafico;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class GeradorModeloGrafico {

	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private LineChartModel modeloGrafico;

	public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.modeloGrafico = new LineChartModel();
	}

	/*public void plotaMediaMovelSimples(){
		Indicador indicador = new MediaMovelSimples();
		LineChartSeries chartSeries = new LineChartSeries("MMS do Fechamento");
		
		for (int i = comeco; i < fim; i++) {
			double valor = indicador.calcula(i, serie);
			chartSeries.set(i, valor);
		}
		this.modeloGrafico.addSeries(chartSeries);
		this.modeloGrafico.setLegendPosition("w");
		this.modeloGrafico.setTitle("Indicadores");
	}*/
	
	public void plotaIndicador(Indicador indicador){
		LineChartSeries chartSeries = new LineChartSeries(indicador.toString());
		
		for (int i = comeco; i < fim; i++) {
			double valor = indicador.calcula(i, serie);
			chartSeries.set(i, valor);
		}
		this.modeloGrafico.addSeries(chartSeries);
		this.modeloGrafico.setLegendPosition("w");
		this.modeloGrafico.setTitle("Indicadores");
	}
	
	public ChartModel getChartModel(){
		return this.modeloGrafico;
	}
}
