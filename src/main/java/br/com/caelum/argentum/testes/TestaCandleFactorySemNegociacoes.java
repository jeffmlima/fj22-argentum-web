package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandleFactorySemNegociacoes {

	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();

		List<Negociacao> negociacoes = Arrays.asList();
		CandleFactory factory = new CandleFactory();

		Candle candle = factory.constroiCandleParaData(hoje, negociacoes);

		System.out.println(candle);
	}

}
