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
	
	public static void main(String[] args) throws InterruptedException {
		//Launch browser, URL and wait for 30 secs
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://finance.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//instantiating the actions class to demonstrate Advanced User Interactions
		Actions action = new Actions(driver);
		
		//Mouse hover to 'News'
		WebElement newshover = driver.findElement(By.xpath("//span[text()='Markets']"));
		action.moveToElement(newshover).perform();
		
		//Click on crypto
		driver.findElement(By.xpath("(//div[text()='Crypto'])[2]")).click();
		
		//Get the crypto names into aa list
		List<WebElement> rowElements = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		System.out.println("The names of the Crypto currencies in the table");
		
		//Use for loop to get the text from the webelements and print it
		for (WebElement rowNames : rowElements) {
			System.out.println(rowNames.getText());
		}
			driver.close();
		}
	
}
