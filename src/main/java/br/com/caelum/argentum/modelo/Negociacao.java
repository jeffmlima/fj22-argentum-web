package br.com.caelum.argentum.modelo;

import java.io.Serializable;
import java.util.Calendar;

public final class Negociacao implements Comparable<Negociacao>, Serializable {

	private static final long serialVersionUID = 1L;
	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("data não pode ser nula");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}

	public double getVolume() {
		return quantidade * preco;
	}

	public boolean isMesmoDia(Calendar outraData) {
		return (this.data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH))
				&& (this.data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH))
				&& (this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR));
	}

	@Override
	public int compareTo(Negociacao o) {
		if (this.data.after(o))
			return 1;
		if(this.data.before(o))
			return -1;
		return 0;
	}
	
}
