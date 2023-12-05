package br.com.iBook.teste;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TestesAnalise {

	@Test
	@Order(1)
	public void testeExclusao() {
		WebDriver browser = new EdgeDriver();
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=AnaliseVendas");

		WebElement campoDtInicio = browser.findElement(By.id("dtInicio"));
		campoDtInicio.sendKeys("01112023");
        
        WebElement campoDtFim = browser.findElement(By.id("dtFim"));
        campoDtFim.sendKeys("10122023");
		
		WebElement botaoGerar = browser.findElement(By.id("acao"));
		botaoGerar.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		browser.quit();
	}
	
}
