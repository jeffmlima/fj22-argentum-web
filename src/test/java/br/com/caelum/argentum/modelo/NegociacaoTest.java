package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class NegociacaoTest {

	@Test
	public void dataDaNegociacaoEhImutavel() {
		//Se criar um negócio no dia 15
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao negociacao = new Negociacao(10, 5, data);
		
		// tentando mudar a data para 20
		negociacao.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		//mas ele continua no 15
		assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10, 5, null);
	}
	
	@Test
	public void mesmoMilisegundoEhDoMesmoDia(){
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar)agora.clone();
		
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void comHorariosDiferentesEhNoMesmoDia(){
		// usando GregorianCalendar(ano, mes, dia, hora, minuto)
		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		
		assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia(){
		Calendar manha = new GregorianCalendar(2001, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 12, 20, 8, 30);
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		
		assertFalse(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia(){
		Calendar manha = new GregorianCalendar(2001, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2012, 10, 20, 8, 30);
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		
		assertFalse(negociacao.isMesmoDia(tarde));
	}

}
