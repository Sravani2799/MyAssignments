package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Creating class to implementing List in AJIO
public class Ajio {
		//main method
	public static void main(String[] args) {
		//initializing the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		//Loaded the URL
		driver.get("https://www.ajio.com/");
		//maximize and wait for the elements to fully load
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Enter bags in search box and click enter
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags", Keys.ENTER); 
		//click on the men option
		driver.findElement(By.xpath("//label[@class='facet-linkname facet-linkname-genderfilter facet-linkname-Men']")).click();
		//Click on the fashion Bags option
		driver.findElement(By.xpath("//label[@class='facet-linkname facet-linkname-l1l3nestedcategory facet-linkname-Men - Fashion Bags']")).click();
		//List to save all the elements found with the given xpath
		List<WebElement> countOfItems = driver.findElements(By.xpath("//div[@class='nameCls']"));
		//To get the size of the List(countOfItems)
		int size = countOfItems.size();
		System.out.println(size);
		//List to save all the elements found with the given xpath
		List<WebElement> listofBrands = driver.findElements(By.xpath("//div[@class='brand']"));
		//Initializing string named listBrandnames to retrive all the brand names into a list
		List<String> listBrandnames = new ArrayList<String>();
		//for loop to iterate through all the elements in listofBrands and save them as a String list in listBrandnames
		for (WebElement each : listofBrands) {
			String text = each.getText();
			System.out.println(text);
			listBrandnames.add(text);
		}
		//List to save all the elements found with the given xpath
		List<WebElement> listofProducts = driver.findElements(By.xpath("//div[@class='nameCls']"));
		//Initializing string named nameofProducts to retrive all the product names into a list
		List<String> nameofProducts = new ArrayList<String>();
		//for loop to iterate through all the elements in listofProducts and save them as a String list in nameofProducts
		for (WebElement each : listofProducts) {
			String text = each.getText();
			System.out.println(text);
			nameofProducts.add(text);
		}
		//To print all the names of brands and products as a list
		System.out.println(listBrandnames);
		System.out.println(nameofProducts);
	}
}