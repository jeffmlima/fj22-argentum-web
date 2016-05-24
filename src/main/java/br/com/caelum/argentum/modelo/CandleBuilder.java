package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;

	private boolean aberturaTest;
	private boolean fechamentoTest;
	private boolean minimoTest;
	private boolean maximoTest;
	private boolean volumeTest;
	private boolean dataTest;

	public CandleBuilder() {
		this.aberturaTest = false;
		this.fechamentoTest = false;
		this.minimoTest = false;
		this.maximoTest = false;
		this.volumeTest = false;
		this.dataTest = false;
	}

	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		this.aberturaTest = true;
		return this;
	}

	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		this.fechamentoTest = true;
		return this;
	}

	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		this.minimoTest = true;
		return this;
	}

	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		this.maximoTest = true;
		return this;
	}

	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		this.volumeTest = true;
		return this;
	}

	public CandleBuilder comData(Calendar data) {
		this.data = data;
		this.dataTest = true;
		return this;
	}

	public Candlestick geraCandle() {
		if (!(aberturaTest && fechamentoTest && minimoTest && maximoTest && volumeTest && dataTest)) {
			throw new IllegalStateException("Todas variáveis devem ser inicializadas");
		}
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
}
