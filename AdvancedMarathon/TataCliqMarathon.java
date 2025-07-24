package AdvancedMarathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataCliqMarathon {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		//To disable Chrome Notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Launch the Browser
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click dont allow on the pop-up
		driver.findElement(By.id("moe-dontallow_button")).click();
		Thread.sleep(3000);
		
		//instatiate Actions class
		Actions act = new Actions(driver);
		
		//hover over brands
		WebElement hoverBrands = driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryAndBrand'])[2]"));
		act.moveToElement(hoverBrands).perform();
		
		//hover over watches
		WebElement hoverWatches = driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryDetailsValue'])[4]"));
		act.moveToElement(hoverWatches).perform();
		
		//click on the first featured brand displayed
		WebElement clickFirstBrandName = driver.findElement(By.xpath("//div[@class='DesktopHeader__featureBrands']/div[2]"));
		act.click(clickFirstBrandName).perform();
		
		//Select New Arrivals under Sortby 
		WebElement selectSortBy = driver.findElement(By.className("SelectBoxDesktop__hideSelect"));
		Select sortby = new Select(selectSortBy);
		sortby.selectByValue("isProductNew");
		
		//Click men under category
		driver.findElement(By.xpath("(//div[text()='Men'])[1]")).click();
		Thread.sleep(2000);
		
		//Getting all the prices of products and storing in priceList
		List<WebElement> priceList = driver.findElements(By.xpath("//div[contains(@class,'priceHolder')]/h3"));
		
		//Creating a list to store the prices
		List<String> prices = new ArrayList<String>();
		
		//Initializing a loop to store the values in String List
		for (WebElement price : priceList) {
			prices.add(price.getText());
			} 
			System.out.println(prices); //print the List
			
			//Print the first element in the List
			String price01 = prices.get(0);
			System.out.println("The price of first product in List: " + price01);
			
			//Click on the first product in the results page
			driver.findElement(By.xpath("(//div[@class='ProductModule__dummyDiv'])[1]")).click();
			
			//Creating a set String to handle the windows and storing them
			Set<String> windowHandles = driver.getWindowHandles();
			
			//As we cannot use duplicates in Set, we will convert it to a List
			List<String> windowsList = new ArrayList<String>(windowHandles);
			
			//Switch to the child window with index '1'.
			driver.switchTo().window(windowsList.get(1));
			
			//Locating and printing the price of the product in child window
			String text = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']")).getText();
			System.out.println("The Price displayed in Child window: " + text);
			
			//verifying if the price of product and first element in list is same
			if(text.contains(price01)) {
				System.out.println("The price is Similar. ");
			} else {
				System.out.println("The price is not Similar. ");
			}
			
			//Click Add to Bag
			driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
			
			//getting and printing the number of items in cart
			String text2 = driver.findElement(By.className("DesktopHeader__cartCount")).getText();
			System.out.println("The number of items in Cart are: " + text2);
			
			//Clicking on the Bag icon to open the cart page
			 driver.findElement(By.className("DesktopHeader__myBagShow")).click();
			 
			//Using for loop to close all the windows one by one 
			for (int i = windowsList.size()-1 ; i >= 0; i--) {
				driver.switchTo().window(windowsList.get(i));
				driver.close(); 
			}
	}
}

