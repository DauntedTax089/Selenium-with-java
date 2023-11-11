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
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ToDoList10Itens {
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
	public void adicionar10Tarefas() {
		// Abrir o site indicado na url
		driver.get(url);

		// Digitar a primeira tarefa
		driver.findElement(By.id("sampletodotext")).clear(); // Limpar a caixa de texto selecionada
		// driver.findElement(By.id("sampletodotext")).sendKeys(Keys.chord("Selenium"));
		// Escrever de forma soletrada
		driver.findElement(By.id("sampletodotext")).sendKeys("Selenium"); // Escrever de forma instantânea
		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		// Assertion - Verificar se a tarefa foi adicionada com sucesso
		String tarefa1 = "Selenium";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa1, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText());
		
		// Digitar a segunda tarefa
		driver.findElement(By.id("sampletodotext")).sendKeys("Cypress"); // Escrever de forma instantânea
		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		// Assertion - Verificar se a tarefa foi adicionada com sucesso
		String tarefa2 = "Cypress";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa2, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[7]/span")).getText());
		
		// Digitar a terceira tarefa
		driver.findElement(By.id("sampletodotext")).sendKeys("JavaScrypt"); // Escrever de forma instantânea
		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		// Assertion - Verificar se a tarefa foi adicionada com sucesso
		String tarefa3 = "JavaScrypt";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa3, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[8]/span")).getText());
		
		// Digitar a quarta tarefa
		driver.findElement(By.id("sampletodotext")).sendKeys("Java"); // Escrever de forma instantânea
		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		// Assertion - Verificar se a tarefa foi adicionada com sucesso
		String tarefa4 = "Java";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa4, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[9]/span")).getText());
		
		// Digitar a quinta tarefa
		driver.findElement(By.id("sampletodotext")).sendKeys("HTML5"); // Escrever de forma instantânea
		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		// Assertion - Verificar se a tarefa foi adicionada com sucesso
		String tarefa5 = "HTML5";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa5, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[10]/span")).getText());
		
		// Digitar a sexta tarefa
		driver.findElement(By.id("sampletodotext")).sendKeys("CSS3"); // Escrever de forma instantânea
		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		// Assertion - Verificar se a tarefa foi adicionada com sucesso
		String tarefa6 = "CSS3";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa6, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[11]/span")).getText());
		
		// Digitar a sétima tarefa
		driver.findElement(By.id("sampletodotext")).sendKeys("GitHub"); // Escrever de forma instantânea
		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		// Assertion - Verificar se a tarefa foi adicionada com sucesso
		String tarefa7 = "GitHub";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa7, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[12]/span")).getText());
		
		// Digitar a oitava tarefa
		driver.findElement(By.id("sampletodotext")).sendKeys("Jira"); // Escrever de forma instantânea
		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		// Assertion - Verificar se a tarefa foi adicionada com sucesso
		String tarefa8 = "Jira";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa8, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[13]/span")).getText());
		
		// Digitar a nona tarefa
		driver.findElement(By.id("sampletodotext")).sendKeys("SeleniumWithJava"); // Escrever de forma instantânea
		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		// Assertion - Verificar se a tarefa foi adicionada com sucesso
		String tarefa9 = "SeleniumWithJava";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa9, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[14]/span")).getText());
		
		// Digitar a décima tarefa
		driver.findElement(By.id("sampletodotext")).sendKeys("API"); // Escrever de forma instantânea
		// Apertar no botão ADD
		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		// Assertion - Verificar se a tarefa foi adicionada com sucesso
		String tarefa0 = "API";
		// assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(tarefa0, driver.findElement(By.xpath("/html/body/div/div/div/ul/li[15]/span")).getText());
	}

}