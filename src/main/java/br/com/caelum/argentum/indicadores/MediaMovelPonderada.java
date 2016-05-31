package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

	private int intervalo;

	public MediaMovelPonderada(int intervalo) {
		if(intervalo<0){
			throw new IllegalArgumentException("Intervalo deve ser maior que zero");
		}
		this.intervalo = intervalo;
	}
	
	@Override
	public double calcula(int posicao, SerieTemporal serie){
		if(posicao<0 || posicao>serie.getTotal()){
			throw new IllegalArgumentException("Posição deve estar compreendida entre 0 e o total de candles");
		}
		if(posicao==0){
			return serie.getCandle(0).getFechamento();
		}
		//se a posição for menor que o intervalo ele calcula até o máxima qtd possível
		int intervaloTemp = intervalo;
		if(intervalo>posicao){
			intervaloTemp = posicao+1;
		}
		double soma = 0.0;
		int peso = intervaloTemp;
		int acumula = peso;
		for (int i = posicao; i > posicao-intervaloTemp; i--) {
			soma += serie.getCandle(i).getFechamento()*peso;
			peso--;
			acumula += peso;
		}
		return soma/acumula;
	}
	
	@Override
	public String toString() {
		return "MMP do Fechamento";
	}
}
