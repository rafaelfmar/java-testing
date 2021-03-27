package ex6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

class TestA {

	@Test
	void test() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://andreendo.github.io/sample-ui-compras/example.html");

		// Adicionar produto
		driver.findElement(By.name("produto")).sendKeys("Novo produto");
		driver.findElement(By.name("quantidade")).sendKeys("1");
		driver.findElement(By.name("quantidade")).submit();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/button")).click();

		// Verificar o nome do maior rótulo (<h1>)
		assertEquals("Lista de compras", driver.findElement(By.tagName("h1")).getText());

		// Clicar no botão nova lista
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/button")).click();

		// Verificar novamente o nome do maior rótulo (<h1>)
		assertEquals("Criar uma lista de compras", driver.findElement(By.tagName("h1")).getText());

		driver.close();
	}

}
