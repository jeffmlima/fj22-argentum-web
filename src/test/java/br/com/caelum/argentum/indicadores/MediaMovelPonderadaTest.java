package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimplesDeCandle() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1,2,3,4,5,6);
		MediaMovelPonderada mmp = new MediaMovelPonderada(5);
		assertEquals(14.0/6, mmp.calcula(2, serie), 0.0001);
		assertEquals(3.0, mmp.calcula(3, serie), 0.0001);
		assertEquals(55.0/15, mmp.calcula(4, serie), 0.0001);
		assertEquals(90.0/20, mmp.calcula(5, serie), 0.0001);
	}

}
