//package br.com.iBook.Teste;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import staticorg.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import br.com.iBook.dominio.Usuario;
//
//public class CrudTest {
//		
//	static Usuario usuario;
//	
//	 public static void main(String[] args) {
//	        // Crie um novo navegador Chrome
//	        WebDriver driver = new ChromeDriver();
//
//	        // Abra a p�gina inicial do Google
//	        driver.get("https://www.google.com/");
//
//	        // Digite "selenium" na caixa de pesquisa
//	        driver.findElement(By.name("q")).sendKeys("selenium");
//
//	        // Clique no bot�o de pesquisa
//	        driver.findElement(By.name("btnK")).click();
//
//	        // Espere at� que a p�gina de resultados da pesquisa seja carregada
//	        driver.wait(1000);
//
//	        // Verifique se o texto "Selenium" aparece na p�gina
//	        String pageTitle = driver.getTitle();
//	        assertTrue(pageTitle.contains("Selenium"));
//
//	        // Feche o navegador
//	        driver.quit();
//	    }
//
//		
//
//}
