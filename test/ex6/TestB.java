package ex6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class TestB {

	@Test
	void test() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://andreendo.github.io/sample-ui-compras/example.html");

		// Adicionar 4 produtos com diferentes quantidades
		Map<String,String> produtos = new HashMap<String,String>();
		produtos.put( "P1", new String( "5" ));
		produtos.put( "P2", new String( "10" ));
		produtos.put( "P3", new String( "15" ));
		produtos.put( "P4", new String( "20" ));

		for (Map.Entry<String, String> entry : produtos.entrySet()) {
			driver.findElement(By.name("produto")).sendKeys(entry.getKey());
			driver.findElement(By.name("quantidade")).sendKeys(entry.getValue());
			driver.findElement(By.name("quantidade")).submit();
		}

		// Remover primeiro e quarto produto
		driver.findElement(By.id("prod0")).click();
		driver.findElement(By.id("prod2")).click();

		
		// Verificar produtos que ficaram
		assertEquals(
				"remover" +  produtos.keySet().toArray()[1] + " - " + produtos.get(produtos.keySet().toArray()[1]), 
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/ul/li[1]")).getText()
				);

		assertEquals(
				"remover" +  produtos.keySet().toArray()[2] + " - " + produtos.get(produtos.keySet().toArray()[2]), 
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/ul/li[2]")).getText()
				);

		driver.close();
	}

}
