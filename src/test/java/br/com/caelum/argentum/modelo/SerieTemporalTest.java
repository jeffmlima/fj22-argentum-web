package br.com.caelum.argentum.modelo;

import org.junit.Test;

import br.com.caelum.argentum.indicadores.GeradorDeSerie;

public class SerieTemporalTest {

	@Test(expected=IllegalArgumentException.class)
	public void testSerieTemporal() {
		new SerieTemporal(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSerieTemporalMenorQTres(){
		GeradorDeSerie.criaSerie(1,2);
	}

}
