package br.com.caelum.argentum.aceitacao;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeraGraficoTest {

	private static final String URL = "http://localhost:8080/fj22-argentum-web/index.xhtml";
	private WebDriver driver;
	
	@Test
	public void testeAoGerarGraficoSemTituloUmaMensagemEhApresentada(){
		driver = new FirefoxDriver();
		driver.navigate().to(URL);
		WebElement titulo = driver.findElement(By.id("dadosGrafico:titulo"));
		titulo.sendKeys();
		titulo.submit();
		Assert.assertTrue(driver.getPageSource().contains("Erro de validação"));
		driver.close();
	}
}
