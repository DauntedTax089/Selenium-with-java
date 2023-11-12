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
	WebDriver driver;
	String produtos = "Products";
	String errorMessage1 = "Epic sadface: Username and password do not match any user in this service";
	String errorMessage2 = "Epic sadface: Username is required";
	String errorMessage3 = "Epic sadface: Password is required";
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public void iniciar() {
		url = "https://www.saucedemo.com/";
		System.setProperty("webdriver.driver.chrome",
				"D:\\Calisto\\Analista de QA\\Portfólio\\Selenium-with-java\\sauceDemoGreen_standard_user\\drivers\\chrome\\chromedriver-win64-119\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	@AfterAll
	public void encerrar() {
		driver.quit();
	}

	@Test
	public void TC01_loginSuccessFully() {
		// Acessar URL
		driver.get(url);

		// Digitar o username "standard_user"
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		// Digitar a password "secret_sauce"
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login foi realizado com sucesso
		assertEquals(produtos, driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText());

	}

	@Test
	public void TC02_invalidUsername() {
		// Acessar URL
		driver.get(url);

		// Digitar o username "vasco_da_gama"
		driver.findElement(By.id("user-name")).sendKeys("vasco_da_gama");

		// Digitar a password "secret_sauce"
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage1,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}

	@Test
	public void TC03_invalidPassword() {
		// Acessar URL
		driver.get(url);

		// Digitar o username "standard_user"
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		// Digitar a password "vasco_da_gama"
		driver.findElement(By.id("password")).sendKeys("vasco_da_gama");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage1,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}

	@Test
	public void TC04_changedCredentials() {
		// Acessar URL
		driver.get(url);

		// Digitar o username "secret_sauce"
		driver.findElement(By.id("user-name")).sendKeys("secret_sauce");

		// Digitar a password "standard_user"
		driver.findElement(By.id("password")).sendKeys("standard_user");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage1,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}

	@Test
	public void TC05_capitalUsername() {
		// Acessar URL
		driver.get(url);

		// Digitar o username "STANDARD_USER"
		driver.findElement(By.id("user-name")).sendKeys("STANDARD_USER");

		// Digitar a password "secret_sauce"
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage1,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}

	@Test
	public void TC06_capitalPassword() {
		// Acessar URL
		driver.get(url);

		// Digitar o username "standard_user"
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		// Digitar a password "SECRET_SAUCE"
		driver.findElement(By.id("password")).sendKeys("SECRET_SAUCE");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage1,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}
	
	@Test
	public void TC07_withoutUsername() {
		// Acessar URL
		driver.get(url);

		// Digitar o username ""
		driver.findElement(By.id("user-name")).sendKeys("");

		// Digitar a password "secret_sauce"
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage2,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}
	
	@Test
	public void TC08_withoutPassword() {
		// Acessar URL
		driver.get(url);

		// Digitar o username "standard_user"
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		// Digitar a password ""
		driver.findElement(By.id("password")).sendKeys("");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage3,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}
	
	@Test
	public void TC09_withoutCredentials() {
		// Acessar URL
		driver.get(url);

		// Digitar o username ""
		driver.findElement(By.id("user-name")).sendKeys("");

		// Digitar a password ""
		driver.findElement(By.id("password")).sendKeys("");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage2,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}
	
	@Test
	public void TC10_backspaceBeforeUsername() {
		// Acessar URL
		driver.get(url);

		// Digitar o username " standard_user"
		driver.findElement(By.id("user-name")).sendKeys(" standard_user");

		// Digitar a password "secret_sauce"
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage1,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}
	
	@Test
	public void TC11_backspaceAfterUsername() {
		// Acessar URL
		driver.get(url);

		// Digitar o username "standard_user "
		driver.findElement(By.id("user-name")).sendKeys(" standard_user");

		// Digitar a password "secret_sauce"
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage1,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}
	
	@Test
	public void TC12_backspaceBeforePassword() {
		// Acessar URL
		driver.get(url);

		// Digitar o username "standard_user"
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		// Digitar a password " secret_sauce"
		driver.findElement(By.id("password")).sendKeys(" secret_sauce");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage1,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}
	
	@Test
	public void TC13_backspaceAfterPassword() {
		// Acessar URL
		driver.get(url);

		// Digitar o username "standard_user"
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		// Digitar a password "secret_sauce "
		driver.findElement(By.id("password")).sendKeys("secret_sauce ");

		// Clicar no botão login
		driver.findElement(By.id("login-button")).click();

		// Assertion - Verificar se login não foi realizado;
		assertEquals(errorMessage1,
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText());

	}
}
