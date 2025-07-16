package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindLinks {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mobiles");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//List to save all the elements related to the xpath in the DOM
		List<WebElement> allprice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		//size of the list
		int size = allprice.size();
		System.out.println(size);
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (WebElement each : allprice) { 	
			String replaceAll = each.getText();
			String replaceAll1 = replaceAll.replaceAll(",", ""); //To replace all the ',' in string to empty
			//To convert the Strings to Integers
			int mob = Integer.parseInt(replaceAll1);
			//To save all the integers to the list Object
			list.add(mob);
		}
			{
				//To sort the integers in ascending order
			Collections.sort(list);
		}
	//To price the complete list of integers
	System.out.println(list);	
	//to print the price at '0' Index
	Integer priceno1 = list.get(0);
	System.out.println(priceno1);
	}
}
