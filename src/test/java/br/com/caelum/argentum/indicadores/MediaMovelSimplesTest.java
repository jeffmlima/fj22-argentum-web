package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.util.GeradorDeSerie;

public class MediaMovelSimplesTest {

	@Test(expected=IllegalArgumentException.class)
	public void sequenciaSimplesDeCandlesFechamento() {
		sequenciaSimplesDeCandles(new IndicadorFechamento(), 5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sequenciaSimplesDeCandlesAbertura() {
		sequenciaSimplesDeCandles(new IndicadorAbertura(), 5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sequenciaSimplesDeCandlesMaximo() {
		sequenciaSimplesDeCandles(new IndicadorMaximo(), 5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sequenciaSimplesDeCandlesMinimo() {
		sequenciaSimplesDeCandles(new IndicadorMinimo(), 5);
	}
	
	private static void sequenciaSimplesDeCandles(Indicador indicador, int intervalo) {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1,2,3,4,3,4,5,4,3);
		Indicador mms = new MediaMovelSimples(indicador, intervalo);
		assertEquals(1.0, mms.calcula(1, serie), 0.0001);
		assertEquals(3.0/2, mms.calcula(2, serie), 0.0001);
		assertEquals(2.0, mms.calcula(3, serie), 0.0001);
		assertEquals(10.0/4, mms.calcula(4, serie), 0.0001);
		assertEquals(13.0/5, mms.calcula(5, serie), 0.0001);
		assertEquals(16.0/5, mms.calcula(6, serie), 0.0001);
		assertEquals(19.0/5, mms.calcula(7, serie), 0.0001);
		assertEquals(4.0, mms.calcula(8, serie), 0.0001);
		assertEquals(19.0/5, mms.calcula(9, serie), 0.0001);
		assertEquals(19.0/5, mms.calcula(10, serie), 0.0001);//gera Illegal pois passou do intervalo
	}

}
