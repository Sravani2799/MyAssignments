package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//Home Assignment
public class FinanceYahoo {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://finance.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions action = new Actions(driver);
		
		WebElement newshover = driver.findElement(By.xpath("//span[text()='Markets']"));
		action.moveToElement(newshover).perform();
		
		driver.findElement(By.xpath("(//div[text()='Crypto'])[2]")).click();
		
		List<WebElement> rowElements = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		
		System.out.println("The names of the Crypto currencies in the table");
		
		for (WebElement rowNames : rowElements) {
			System.out.println(rowNames.getText());
		}
	}
}
