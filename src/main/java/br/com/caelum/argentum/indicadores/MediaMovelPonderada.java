package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

	private int intervalo;
	private final Indicador indicador;

	public MediaMovelPonderada(Indicador indicador, int intervalo) {
		if (intervalo < 1) {
			throw new IllegalArgumentException("Intervalo deve ser uma unidade maior que zero");
		}
		this.intervalo = intervalo;
		this.indicador = indicador;
	}

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		// posição indica o dia, iniciando a partir de 1
		if (posicao < 1 || posicao > (serie.getUltimaPosicao() + 1)) {
			throw new IllegalArgumentException("Posição deve estar compreendida entre 1 e o total de candles");
		}
		if (posicao == 1) {
//			return serie.getCandle(0).getFechamento();
			return indicador.calcula(0, serie);
		}
		// se a posição for menor que o intervalo ele calcula até o máxima qtd possível
		int intervaloTemp = intervalo;
		if (intervalo > posicao) {
			intervaloTemp = posicao;
		}
		double soma = 0.0;
		int acumula, peso;
		acumula = peso = intervaloTemp;
		for (int i = (posicao - 1); i >= posicao - intervaloTemp; i--) {
//			soma += serie.getCandle(i).getFechamento() * peso;
			soma += indicador.calcula(i, serie) * peso;
			peso--;
			acumula += peso;
		}
		return soma / acumula;
	}

	@Override
	public String toString() {
		return "MMP do Fechamento";
	}
}
