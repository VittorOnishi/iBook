package br.com.iBook.teste;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


@TestMethodOrder(OrderAnnotation.class)
public class TestesConducao {

	@Test
	@Order(1)
	public void teste1Compra() {
		WebDriver browser = new EdgeDriver();
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=PaginaInicial");
		
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=ExibeDadosProduto&id=14");

        WebElement selectElement = browser.findElement(By.id("qtdeItens"));
        
        Select select = new Select(selectElement);
        select.selectByVisibleText("4"); 
        
        WebElement adicionarAoCarrinhoButtonCasoEvandro = browser.findElement(By.className("produto__links__adiciona__carrinho"));
        adicionarAoCarrinhoButtonCasoEvandro.click();
        
        browser.navigate().to("http://localhost:8080/iBook/controller?acao=ExibeDadosProduto&id=12");
        
        WebElement selectElement2 = browser.findElement(By.id("qtdeItens"));
        Select select2 = new Select(selectElement2);
        select2.selectByVisibleText("5"); 
        
        WebElement adicionarAoCarrinhoButtonIt = browser.findElement(By.className("produto__links__adiciona__carrinho"));
        adicionarAoCarrinhoButtonIt.click();
        
        browser.navigate().to("http://localhost:8080/iBook/controller?acao=ExibeDadosProduto&id=11");
        
        WebElement selectElement3 = browser.findElement(By.id("qtdeItens"));
        Select select3 = new Select(selectElement3);
        select3.selectByVisibleText("1"); 
        
        WebElement adicionarAoCarrinhoButtonHp = browser.findElement(By.className("produto__links__adiciona__carrinho"));
        adicionarAoCarrinhoButtonHp.click();
        
        browser.navigate().to("http://localhost:8080/iBook/controller?acao=Carrinho");
        
        WebElement continuarCompra = browser.findElement(By.id("acao"));
        continuarCompra.click();
        
        List<WebElement> checkboxEndereco = browser.findElements(By.className("checkmark"));
        checkboxEndereco.get(0).click();
        
        WebElement confirmarLink = browser.findElement(By.className("entrega__frete__confirmar"));
        confirmarLink.click();
        
        List<WebElement> checkboxCartao = browser.findElements(By.className("checkmark"));
        checkboxCartao.get(0).click();
        
        WebElement fecharPedido = browser.findElement(By.id("acao"));
        fecharPedido.click();

	    browser.quit();
	}
	
	@Test
	@Order(2)
	public void teste2AlterarStatusEntregue() {
		
		WebDriver browser = new EdgeDriver();
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=Perfil&id=108");
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=PaginaConsultaVendas");
		
		 WebElement selectElement = browser.findElement(By.id("statusPedido"));
	        
	        Select select = new Select(selectElement);
	        select.selectByVisibleText("ENTREGUE"); 
	        
	        WebElement alterarStatus = browser.findElement(By.id("acao"));
	        alterarStatus.click();
		
		browser.quit();
	}
	
	@Test
	@Order(3)
	public void teste3SolicitarTroca() {
		
		WebDriver browser = new EdgeDriver();
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=ConsultarPedido&id=110");
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=VerItensPedido&id=254");
	
        List<WebElement> solicitarTroca = browser.findElements(By.className("compras__lista__produtos__produto__trocar__produto"));
	    solicitarTroca.get(0).click();
	    
		browser.quit();
	}
	
	@Test
	@Order(4)
	public void teste4AlterarStatusTrocaRealizada() {
		
		WebDriver browser = new EdgeDriver();
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=Perfil&id=108");
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=PaginaConsultaVendas");
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=VerItensPedido&id=254");
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=VerItem&id=348");
		
		 WebElement selectElement = browser.findElement(By.id("statusItem"));
	        
	        Select select = new Select(selectElement);
	        select.selectByVisibleText("TROCA REALIZADA"); 
	        
	        WebElement alterarStatus = browser.findElement(By.id("acao"));
	        alterarStatus.click();
		
		browser.quit();
	}
	
	@Test
	@Order(5)
	public void teste5CompraCupom() {
		WebDriver browser = new EdgeDriver();
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=PaginaInicial");
		
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=ExibeDadosProduto&id=14");

        WebElement selectElement = browser.findElement(By.id("qtdeItens"));
        
        Select select = new Select(selectElement);
        select.selectByVisibleText("3"); 
        
        WebElement adicionarAoCarrinhoButtonCasoEvandro = browser.findElement(By.className("produto__links__adiciona__carrinho"));
        adicionarAoCarrinhoButtonCasoEvandro.click();
        
        browser.navigate().to("http://localhost:8080/iBook/controller?acao=ExibeDadosProduto&id=11");
        
        WebElement selectElement2 = browser.findElement(By.id("qtdeItens"));
        Select select2 = new Select(selectElement2);
        select2.selectByVisibleText("2"); 
        
        WebElement adicionarAoCarrinhoButtonIt = browser.findElement(By.className("produto__links__adiciona__carrinho"));
        adicionarAoCarrinhoButtonIt.click();
        
        browser.navigate().to("http://localhost:8080/iBook/controller?acao=ExibeDadosProduto&id=10");
        
        WebElement selectElement3 = browser.findElement(By.id("qtdeItens"));
        Select select3 = new Select(selectElement3);
        select3.selectByVisibleText("2"); 
        
        WebElement adicionarAoCarrinhoButtonHp = browser.findElement(By.className("produto__links__adiciona__carrinho"));
        adicionarAoCarrinhoButtonHp.click();
        
        browser.navigate().to("http://localhost:8080/iBook/controller?acao=Carrinho");
        
        WebElement continuarCompra = browser.findElement(By.id("acao"));
        continuarCompra.click();
        
        List<WebElement> checkboxEndereco = browser.findElements(By.className("checkmark"));
        checkboxEndereco.get(0).click();
        
        WebElement confirmarLink = browser.findElement(By.className("entrega__frete__confirmar"));
        confirmarLink.click();
        
        browser.navigate().to("http://localhost:8080/iBook/controller?acao=ConsultarCupons&id=110");
        
        List<WebElement> checkboxCupom = browser.findElements(By.className("checkmark"));
        checkboxCupom.get(0).click();
        
        WebElement selecionarCupom = browser.findElement(By.id("acao"));
        selecionarCupom.click();
        
        List<WebElement> checkboxCartao = browser.findElements(By.className("checkmark"));
        checkboxCartao.get(0).click();
        
        WebElement fecharPedido = browser.findElement(By.id("acao"));
        fecharPedido.click();

	    browser.quit();
	}
	
	@Test
	@Order(6)
	public void testeCarrinho() {
		WebDriver browser = new EdgeDriver();
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=PaginaInicial");
		
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=ExibeDadosProduto&id=14");

        WebElement selectElement = browser.findElement(By.id("qtdeItens"));
        
        Select select = new Select(selectElement);
        select.selectByVisibleText("3"); 
        
        WebElement adicionarAoCarrinhoButtonCasoEvandro = browser.findElement(By.className("produto__links__adiciona__carrinho"));
        adicionarAoCarrinhoButtonCasoEvandro.click();
        
        browser.navigate().to("http://localhost:8080/iBook/controller?acao=ExibeDadosProduto&id=11");
        
        WebElement selectElement2 = browser.findElement(By.id("qtdeItens"));
        Select select2 = new Select(selectElement2);
        select2.selectByVisibleText("2"); 
        
        WebElement adicionarAoCarrinhoButtonIt = browser.findElement(By.className("produto__links__adiciona__carrinho"));
        adicionarAoCarrinhoButtonIt.click();
        
        browser.navigate().to("http://localhost:8080/iBook/controller?acao=ExibeDadosProduto&id=10");
        
        WebElement selectElement3 = browser.findElement(By.id("qtdeItens"));
        Select select3 = new Select(selectElement3);
        select3.selectByVisibleText("2"); 
        
        WebElement adicionarAoCarrinhoButtonHp = browser.findElement(By.className("produto__links__adiciona__carrinho"));
        adicionarAoCarrinhoButtonHp.click();
        
        browser.navigate().to("http://localhost:8080/iBook/controller?acao=Carrinho");
        
        WebElement excluirDoCarrinho = browser.findElement(By.id("excluirDoCarrinho"));
        excluirDoCarrinho.click();
        
        WebElement alterarDoCarrinho = browser.findElement(By.id("alterarDoCarrinho"));
        alterarDoCarrinho.click();
        
        WebElement qtdeElementosCarrinho = browser.findElement(By.id("qtdeItens"));
        Select selectCarrinho = new Select(qtdeElementosCarrinho);
        selectCarrinho.selectByVisibleText("9"); 
        
        WebElement alterarQtde = browser.findElement(By.id("acao"));
        alterarQtde.click();
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
	    browser.quit();
	}

}
