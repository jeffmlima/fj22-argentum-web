package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderadaTest {

	@Test(expected=IllegalArgumentException.class)
	public void sequenciaSimplesDeCandleFechamento() {
		sequenciaSimplesDeCandle(new IndicadorFechamento(), 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sequenciaSimplesDeCandleAbertura() {
		sequenciaSimplesDeCandle(new IndicadorFechamento(), 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sequenciaSimplesDeCandleMaximo() {
		sequenciaSimplesDeCandle(new IndicadorMaximo(), 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sequenciaSimplesDeCandleMinimo() {
		sequenciaSimplesDeCandle(new IndicadorMinimo(), 3);
	}
	
	private void sequenciaSimplesDeCandle(Indicador indicador, int intervalo) {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1,2,3,4,5,6);
		MediaMovelPonderada mmp = new MediaMovelPonderada(indicador, intervalo);
		assertEquals(1.0, mmp.calcula(1, serie), 0.0001);
		assertEquals(5.0/3, mmp.calcula(2, serie), 0.0001);
		assertEquals(14.0/6, mmp.calcula(3, serie), 0.0001);
		assertEquals(20.0/6, mmp.calcula(4, serie), 0.0001);
		assertEquals(26.0/6, mmp.calcula(5, serie), 0.0001);
		assertEquals(32.0/6, mmp.calcula(6, serie), 0.0001);
		assertEquals(5.0/3, mmp.calcula(7, serie), 0.0001);//gera Illegal pois passou do intervalo
	}
}
