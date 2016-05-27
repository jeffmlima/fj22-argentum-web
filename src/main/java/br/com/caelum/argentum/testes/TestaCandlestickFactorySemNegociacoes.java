package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactorySemNegociacoes {

	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();

		List<Negociacao> negociacoes = Arrays.asList();
		CandlestickFactory factory = new CandlestickFactory();

		Candle candle = factory.constroiCandleParaData(hoje, negociacoes);

		System.out.println(candle);
	}

}
