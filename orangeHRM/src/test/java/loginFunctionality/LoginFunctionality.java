package loginFunctionality;

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
public class LoginFunctionality {
	String url;
	String dashboard = "Dashboard";
	String errorMessage1 = "Invalid credentials";
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeAll
	public void iniciar() {
		url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		System.setProperty("webdriver.driver.chrome",
				"D:\\Calisto\\Analista de QA\\Portfólio\\Selenium-with-java\\orangeHRM\\drivers\\chrome\\chromedriver-win64-119\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	@AfterAll
	public void finalizar() {
	}

	@Test
	public void TC01_loginSuccessFully() {
		// Acessar website
		driver.get(url);

		// Digitar o username:"Admin"
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
				.sendKeys("Admin");

		// Digitar o password:"admin123"
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
				.sendKeys("admin123");

		// Clicar no botão login
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

		// Assertion - Verificar se o login foi realizado com sucesso
		assertEquals(dashboard,
				driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText());
	}
}