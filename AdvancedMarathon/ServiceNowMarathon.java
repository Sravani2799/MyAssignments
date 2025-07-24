package AdvancedMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNowMarathon {
	public static void main(String[] args) throws InterruptedException {
		//To disable Chrome notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Launch the Browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev209663.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Input username password and click submit 
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("qy/Q6A=vOM3x");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);
		
		/*
		 * As the 'All option is inside the shadow root, instantiating the Shadow
		 * class and click 'All' and selecting service catalog
		 */
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		
		//Handling the frame and switching to it 
		WebElement frameElement = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameElement);
		
		//Clicking on the mobile option
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();

		//Click on Iphone 13 pro
		driver.findElement(By.xpath("//a[@id='item_link_73b1bafa9752cd1021983d1e6253afb5']")).click();
		
		//Selecting Yes radio button under "Is this a replacement for a lost or broken iPhone?" 
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		Thread.sleep(5000);
		
		//Entering '99' under  "What was the original phone number?"
		driver.findElement(By.xpath("//input[@id='IO:4afecf4e9747011021983d1e6253af34']")).sendKeys("99");
		//Selecting Unlimited under "Monthly data allowance DD"
		WebElement dataallowanceDD = driver.findElement(By.xpath("//select[@name='IO:ff1f478e9747011021983d1e6253af68']"));
		Select dataallowance = new Select(dataallowanceDD);
		dataallowance.selectByContainsVisibleText("Unlimited [add $4.00]");
		
		//Selecting Sierra Blue and 512GB storage radio buttons and click on "Order Now"
		driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
		driver.findElement(By.xpath("//label[text()='512 GB [add $300.00]']")).click();
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
		//Retrieving text to confirm order status
		String orderStatus = driver.findElement(By.xpath("//dl[@class='dl-horizontal sc-dl-horizontal']/dt")).getText();
		String verifyOrder = "Order Placed";
		
		//implementing if condition to verify if the order is placed
		if(orderStatus.contains(verifyOrder)) {
			System.out.println("The Order is Placed");
			String requestNumber = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
			System.out.println("The Request Number is: " + requestNumber);
		} else {
			System.out.println("The Order is not Placed");
		}
		
		//Getting the window handle
		System.out.println(driver.getWindowHandle());
		
		//Getting URL of the Order Confirmation Page
		System.out.println("URL: "+ driver.getCurrentUrl());
		
		//Close the window
		driver.close();
	}

}
