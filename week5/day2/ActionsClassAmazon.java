package week5.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActionsClassAmazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		//Initializing the browser and loading URL
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Iphone 15 pro is searched
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone 15 pro", Keys.ENTER);
		
		//Price has been captured for the first product
		String priceof1st = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price of first item: " + priceof1st);
		
		//Hover to reviews and print the no.of reviews of the product
		String reviewshover = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("Total number of reviews for the product: " + reviewshover);
		
		//Open the first product page
		driver.findElement(By.xpath("(//div[@data-cy='title-recipe'])[1]/a")).click();
		Thread.sleep(3000);
		
		//Take a screenshot of the product page
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("screenshot.png"));
		
		//Add to Cart
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		
		//Navigate to cart and click
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		
		//print the subtotal of the cart
		String subTotal = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]")).getText();
		System.out.println("Sub-total of the cart: " + subTotal);
		
		//Confirm the cart value 
		if(subTotal.contains(priceof1st)) {
			System.out.println("The price is correct.");
		} else {
			System.out.println("The price is not correct.");
		}
		
		//Close the driver 
		driver.close();
	}

}
