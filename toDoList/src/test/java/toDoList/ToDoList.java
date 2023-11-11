// 1 - Pacote
package toDoList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// 2 -Biblioteca

// 3 - Classe
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ToDoList {
	// 3.1 - Atributos/Características
	String url; // Endereço do site
	WebDriver driver; // Objeto do selenium-webdriver

	// 3.2 Métodos ou funções
	@SuppressWarnings("deprecation")
	@BeforeAll
	public void Iniciar() {
		url = "https://lambdatest.github.io/sample-todo-app/";
		System.setProperty("webdriver.chrome.driver",
				"D:\\Calisto\\Analista de QA\\Portfólio\\Selenium-with-java\\toDoList\\drivers\\chrome\\chromedriver-win64-119\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS); // Tempo de espera para realizar as
																					// ações do teste
		driver.manage().window().maximize();// Maximizar a janela do navegador
	}

	@AfterAll
	public void Finalizar() {
		driver.quit();//Fechar o teste
	}

	@Test
	public void adicionarTarefa() {
		// Abrir o site indicado na url
		driver.get(url);

		// Digitar a tarefa a ser adicionada
		driver.findElement(By.id("sampletodotext")).clear(); // Limpar a caixa de texto selecionada
		// driver.findElement(By.id("sampletodotext")).sendKeys(Keys.chord("Selenium"));
		// Escrever de forma soletrada
		driver.findElement(By.id("sampletodotext")).sendKeys("Selenium"); // Escrever de forma instantânea

		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();

		// Assertion - Verificar se o curso foi adicionado com sucesso
		String tarefa = "Selenium";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText());
	}

}