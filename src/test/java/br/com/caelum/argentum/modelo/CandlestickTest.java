package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candlestick(10, 20, 20, 10, 1000, Calendar.getInstance());
	}

	@Test
	public void quandoAberturaIgualFechamentoEhAlta(){
		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(negociacao1);
		CandlestickFactory factory = new CandlestickFactory();

		Candlestick candle = factory.constroiCandleParaData(hoje, negociacoes);
		assertTrue(candle.isAlta());
		assertFalse(candle.isBaixa());
	}
}
