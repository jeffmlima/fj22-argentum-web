package br.com.caelum.argentum.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {
	private final String nomeIndicador;
	private final String nomeMedia;

	public IndicadorFactory(String nomeMedia, String nomeIndicador) {
		this.nomeIndicador = nomeIndicador;
		this.nomeMedia = nomeMedia;
	}

	public Indicador defineIndicador() {
		if (nomeIndicador == null || nomeMedia == null)
			return new MediaMovelSimples(new IndicadorFechamento(), 3);
		try {
			String pacote = "br.com.caelum.argentum.indicadores.";
			Class<?> classeIndicadorBase = Class.forName(pacote + nomeIndicador);
			Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();

			Class<?> classeMedia = Class.forName(pacote + nomeMedia);
			Constructor<?> constructorMedia = classeMedia.getConstructor(Indicador.class, int.class);
			Indicador indicador = (Indicador) constructorMedia.newInstance(indicadorBase, 3);
			return indicador;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
