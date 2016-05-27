package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.List;

public class SerieTemporal {

	private final List<Candle> candles;

	public SerieTemporal(List<Candle> candles) {
		this.candles = candles;
	}
	
	public Candle getCandle(int i){
		return this.candles.get(i);
	}
	
	public int getTotal(){
		return this.candles.size();
	}
	
	public int getUltimaPosicao(){
		return this.candles.size()-1;
	}
	
	public List<Candle> getCandles(){
		List<Candle> c = new ArrayList<Candle>();
		c.addAll(candles);
		return c;
	}

}