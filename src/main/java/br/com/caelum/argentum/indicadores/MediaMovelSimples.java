package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples {

	public double calcula(int posicao, SerieTemporal serie){
		if(serie.getCandles().isEmpty() || serie.getCandles()==null){
			throw new IllegalArgumentException("Lista de candles deve conter candles válidos");
		}
		double soma = 0.0;
		for (int i = posicao; i > posicao-3; i--) {
			soma += serie.getCandle(i).getFechamento();
		}
		return soma/3;
	}
}
