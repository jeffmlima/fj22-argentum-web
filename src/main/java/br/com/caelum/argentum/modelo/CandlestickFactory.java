package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		// double maximo = Double.MIN_VALUE;
		double maximo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		// double minimo = Double.MAX_VALUE;
		double minimo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double volume = 0;

		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();

			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();

		return new CandleBuilder().comAbertura(abertura).comFechamento(fechamento).comMinimo(minimo).comMaximo(maximo)
				.comVolume(volume).comData(data).geraCandle();
	}

	public List<Candlestick> constroiCandles(List<Negociacao> todasNegociacoes) {
		Collections.sort(todasNegociacoes);
		List<Candlestick> candles = new ArrayList<>();

		List<Negociacao> negociacoesDoDia = new ArrayList<>();
		Calendar dataAtual = todasNegociacoes.get(0).getData();

		for (Negociacao negociacao : todasNegociacoes) {

			// se não for mesmo dia, fecha candle e reinicia variáveis
			if (!negociacao.isMesmoDia(dataAtual)) {
				Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);

				candles.add(candleDoDia);
				negociacoesDoDia = new ArrayList<>();
				dataAtual = negociacao.getData();
			}
			negociacoesDoDia.add(negociacao);
		}
		// adiciona último candle
		Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
		candles.add(candleDoDia);
		return candles;
	}
}
