package br.com.iBook.teste;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

@TestMethodOrder(OrderAnnotation.class)
public class TestesCrudCliente {

	@Test
	@Order(1)
	public void testeCadastro() {
		WebDriver browser = new EdgeDriver();
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=formCadastroUsuario");
		
		//Dados pessoais
        WebElement campoNome = browser.findElement(By.id("nomeCliente"));
        campoNome.sendKeys("Rodrigo Rocha");
        
        WebElement campoGenero = browser.findElement(By.id("genero"));
        Select genero = new Select(campoGenero);
        genero.selectByValue("Masculino");
        
        WebElement campoDtNasc = browser.findElement(By.id("dataNasc"));
        campoDtNasc.sendKeys("01011990");
        
        WebElement campoCpf = browser.findElement(By.id("cpf"));
        campoCpf.sendKeys("123.456.789-00");
        
        WebElement campoTelefone = browser.findElement(By.id("telefone"));
        campoTelefone.sendKeys("12 34567-8900");
       
        WebElement campoTipoTelefone = browser.findElement(By.id("tipoTelefone"));
        Select telefone = new Select(campoTipoTelefone);
        telefone.selectByValue("Residencial");
        
        WebElement campoEmail = browser.findElement(By.id("e-mail"));
        campoEmail.sendKeys("rodrigo@rocha.com.br");
        
        WebElement campoSenha = browser.findElement(By.id("senha"));
        campoSenha.sendKeys("suaSenha123");
        
        WebElement campoSenhaConfirm = browser.findElement(By.id("senhaConfirmacao"));
        campoSenhaConfirm.sendKeys("suaSenha123");
        
        //Dados cartão
        WebElement nrCartaoInput = browser.findElement(By.id("nrCartao"));
        nrCartaoInput.sendKeys("123456789012");
        
        WebElement bandeiraCartaoDropdown = browser.findElement(By.id("bandeiraCartao"));
        Select selectBandeira = new Select(bandeiraCartaoDropdown);
        selectBandeira.selectByIndex(1); 
        
        WebElement nomeCartaoInput = browser.findElement(By.id("nomeCartao"));
        nomeCartaoInput.sendKeys("Nome do Portador");
        
        WebElement codigoSegCartaoInput = browser.findElement(By.id("codigoSegCartao"));
        codigoSegCartaoInput.sendKeys("123");

        //Endereço residencial
        WebElement tipoResidencia = browser.findElement(By.id("tipoResidenciaResidencial"));
        Select selectTipoResidencia = new Select(tipoResidencia);
        selectTipoResidencia.selectByValue("casa");

        WebElement logradouro = browser.findElement(By.id("logradouroResidencial"));
        logradouro.sendKeys("Rua Pedro Paulo");

        WebElement tipoLogradouro = browser.findElement(By.id("tipoLogradouroResidencial"));
        Select selectTipoLogradouro = new Select(tipoLogradouro);
        selectTipoLogradouro.selectByValue("rua");

        WebElement numero = browser.findElement(By.id("numeroResidencial"));
        numero.sendKeys("123");

        WebElement observacao = browser.findElement(By.id("observacaoResidencial"));
        observacao.sendKeys("Próximo ao mercado");

        WebElement bairro = browser.findElement(By.id("bairroResidencial"));
        bairro.sendKeys("Mogilar");

        WebElement cep = browser.findElement(By.id("cepResidencial"));
        cep.sendKeys("12345-678");

        WebElement cidade = browser.findElement(By.id("cidade"));
        cidade.sendKeys("Mogi das Cruzes");

        WebElement estado = browser.findElement(By.id("estadoResidencial"));
        Select selectEstado = new Select(estado);
        selectEstado.selectByValue("SP");

        WebElement pais = browser.findElement(By.id("paisResidencial"));
        pais.sendKeys("Brasil");
        
        //Endereço entrega
        WebElement tipoResidenciaEntrega = browser.findElement(By.id("tipoResidenciaEntrega"));
        Select selectTipoResidenciaEntrega = new Select(tipoResidenciaEntrega);
        selectTipoResidenciaEntrega.selectByValue("casa");

        WebElement logradouroEntrega = browser.findElement(By.id("logradouroEntrega"));
        logradouroEntrega.sendKeys("Rua Paulo Silva");

        WebElement tipoLogradouroEntrega = browser.findElement(By.id("tipoLogradouroEntrega"));
        Select selectTipoLogradouroEntrega = new Select(tipoLogradouroEntrega);
        selectTipoLogradouroEntrega.selectByValue("rua");

        WebElement numeroEntrega = browser.findElement(By.id("numeroEntrega"));
        numeroEntrega.sendKeys("567");

        WebElement observacaoEntrega = browser.findElement(By.id("observacaoEntrega"));
        observacaoEntrega.sendKeys("Próximo ao mercado");

        WebElement bairroEntrega = browser.findElement(By.id("bairroEntrega"));
        bairroEntrega.sendKeys("Mogilar");

        WebElement cepEntrega = browser.findElement(By.id("cepEntrega"));
        cepEntrega.sendKeys("12345-678");

        WebElement cidadeEntrega = browser.findElement(By.id("cidadeEntrega"));
        cidadeEntrega.sendKeys("Mogi das Cruzes");

        WebElement estadoEntrega = browser.findElement(By.id("estadoEntrega"));
        Select selectEstadoEntrega = new Select(estadoEntrega);
        selectEstadoEntrega.selectByValue("SP");

        WebElement paisEntrega = browser.findElement(By.id("paisEntrega"));
        paisEntrega.sendKeys("Brasil");
        
        // Você pode adicionar aqui o código para submeter o formulário se houver um botão de envio
        WebElement botaoEnviar = browser.findElement(By.className("cliente__cadastro__cadastrar"));
        botaoEnviar.click();

        // Aguarde algum tempo para visualizar o resultado (opcional)
        try {
            Thread.sleep(5000);  // Aguarda 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        browser.quit();
    }

	@Test
	@Order(2)
	public void testeConsultaAlteração() {
		WebDriver browser = new EdgeDriver();
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=PaginaConsultaUsuarios");

		WebElement paramPesquisa = browser.findElement(By.id("paramBuscaCliente"));
		paramPesquisa.sendKeys("Rodrigo Rocha");

		WebElement botaoEnviar = browser.findElement(By.id("botao_busca_clientes"));
		botaoEnviar.click();

		WebElement visualizarDados = browser.findElement(By.id("visualizarDadosCliente"));
		visualizarDados.click();

		WebElement formAlteracao = browser.findElement(By.id("alterarDadosCliente"));
		formAlteracao.click();

		// Dados pessoais
		WebElement campoNome = browser.findElement(By.id("nomeCliente"));
		campoNome.clear();
		campoNome.sendKeys("Rodrigo Rocha Silva");

	    WebElement botaoAtualizar = browser.findElement(By.id("atualizarDadosCliente"));
	    botaoAtualizar.click();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		browser.quit();
	}
	
	@Test
	@Order(3)
	public void testeExclusao() {
		WebDriver browser = new EdgeDriver();
		browser.navigate().to("http://localhost:8080/iBook/controller?acao=PaginaConsultaUsuarios");

		WebElement paramPesquisa = browser.findElement(By.id("paramBuscaCliente"));
		paramPesquisa.sendKeys("Rodrigo Rocha");
		
		WebElement botaoBuscar = browser.findElement(By.id("botao_busca_clientes"));
		botaoBuscar.click();

		WebElement botaoExcluir = browser.findElement(By.id("excluirCliente"));
		botaoExcluir.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		browser.quit();
	}

}
