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
//	        // Abra a página inicial do Google
//	        driver.get("https://www.google.com/");
//
//	        // Digite "selenium" na caixa de pesquisa
//	        driver.findElement(By.name("q")).sendKeys("selenium");
//
//	        // Clique no botão de pesquisa
//	        driver.findElement(By.name("btnK")).click();
//
//	        // Espere até que a página de resultados da pesquisa seja carregada
//	        driver.wait(1000);
//
//	        // Verifique se o texto "Selenium" aparece na página
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
