package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

public class IndicadorFactoryTest {

	@Test
	public void defineIndicadorTest() {
		assertEquals(new MediaMovelSimples(new IndicadorFechamento(), 3),
				new IndicadorFactory("MediaMovelSimples",null).defineIndicador());
	}

}
