package week5.day2;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

//Home Assignment
public class ActionsClassBigBasket {

	public static void main(String[] args) throws IOException, InterruptedException {
		//initializing the browser and URl
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Hover to Categories > FoodGrains > Rice Products
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']")).click();
		Actions action = new Actions(driver);
		WebElement foodGrains = driver.findElement(By.xpath("(//ul[@role='none']/li/a[text()='Foodgrains, Oil & Masala'])[1]"));
		action.moveToElement(foodGrains).perform();
		Thread.sleep(3000);
		WebElement riceProducts = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		action.moveToElement(riceProducts).perform();
		Thread.sleep(3000);
		
		//Click Boiled and Steam Rice
		driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
		Thread.sleep(3000);
		
		//Select product Tamil Ponni Boiled Rice
		driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']")).click();
		
		//Get window handles with Set String
		Set<String> windowHandles = driver.getWindowHandles();
		
		//Convert set to List to handle duplicate values if any
		List<String> windows = new ArrayList<String>(windowHandles);
		
		//switch to child window and get title
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		
		//Add to basket
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		Thread.sleep(1000);
		
		//Success messge printed
		WebElement successMsg = driver.findElement(By.xpath("//div[@class='Toast___StyledDiv-sc-1uergwq-0 kLrmgR']/p"));
		String text = successMsg.getText();
		System.out.println(text);
		
		//Screenshot capture
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("screenshotBB.png"));
		Thread.sleep(5000);
		
		//driver close in an order
		driver.close();
		driver.switchTo().window(windows.get(0));
		driver.close();
	}

}
