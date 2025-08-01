package week5.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

//Home Assignment
public class ActionClassSnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Initialising the browser and loading URL
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		
		//Hover to mens fashion with acctions class and click sports shoes
		WebElement mensHover = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(mensHover).perform();
		WebElement sportsShoes = driver.findElement(By.xpath("//a[@data-index='1.1.2']/span[text()='Sports Shoes']"));
		sportsShoes.click();
		
		//print no.of products
		String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println(text);
		
		//click training shoes and sort low to high price
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sorting-sec animBounce']/div")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		
		Thread.sleep(2000);
		
		//Check if the sorting is done correctly by checking the first 2 prices
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		if (prices.size()>=2) {
			int int1 = Integer.parseInt(prices.get(0).getText().replaceAll("[^0-9]", ""));	
			int int2 = Integer.parseInt(prices.get(1).getText().replaceAll("[^0-9]", ""));	
		if (int1<=int2) {
			System.out.println("Sorted Correctly");
		} else {
			System.out.println("Not Sorted Correctly");
		}
		
		/*
		 * List<String> priceList = new ArrayList<String>();
		 * 
		 * for (WebElement each : prices) { String text2 = each.getText();
		 * priceList.add(text2); } System.out.println(priceList);
		 */
		
		//assigning String variable to pass the from and to price filter
		String from = "600";
		String to = "900";
		
		//Giving from and to value and selecting the colour
		WebElement fromVal = driver.findElement(By.name("fromVal"));
		fromVal.clear();
		fromVal.sendKeys(from);
		WebElement toVal = driver.findElement(By.name("toVal"));
		toVal.clear();
		toVal.sendKeys(to);
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(3000);
		WebElement colourSelect = driver.findElement(By.xpath("//label[contains(., 'White') and contains(., 'Blue')]"));
		String selectedColour = colourSelect.getText();
		colourSelect.click();
		
		Thread.sleep(3000);
		
		//Verifying if the filters are applied individually by retrieveing the webelement text into a list and applying if condition
		List<WebElement> filters = driver.findElements(By.xpath("//div[@class='filters']//a"));
		List<String> filterName = new ArrayList<String>();
		for (WebElement filter : filters) {
			String text2 = filter.getText();
			filterName.add(text2);
		}
		if (filterName.get(0).contains(from) || filterName.get(0).contains(to)) {
				System.out.println("The price selected is correct: " + filterName.get(0)); 
				} else {
				System.out.println("The price selected is not correct."); 
		}
		if (selectedColour.contains(filterName.get(1))) {
			System.out.println("Colour is confirmed: " + filterName.get(1)); 
			}
		 else { System.out.println("Colour is not confirmed."); 
		}
		
		//moving to first product and clicking Quick View
		WebElement firstProductHover = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(firstProductHover).perform();
		WebElement quickView = driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
		quickView.click();
		
		//Get and print the price and discount of the product
		WebElement priceOfProduct = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[1]"));
		String text2 = priceOfProduct.getText();
		String replace = text2.replace("[^0-9]", "");
		
		String discountApplied = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[2]")).getText();
		System.out.println("Price of the Product: " + replace);
		System.out.println("Discount of the Product: " + discountApplied);
		
		//capturing the screenshot of the product and closing the window
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("screenshotSnapDeal.png"));
		driver.quit();
		}
	}
}