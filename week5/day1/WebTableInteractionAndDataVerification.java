package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Class Assignment
public class WebTableInteractionAndDataVerification {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://erail.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS", Keys.ENTER);
		
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU", Keys.ENTER);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		driver.findElement(By.id("buttonFromTo")).click();
		
		List<WebElement> trainNames = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody/tr/td[2]"));
		int sizeOfTrains = trainNames.size();
		System.out.println("The list of trains from MAS to MDU : " + sizeOfTrains);
		
		List<String> trainnames = new ArrayList<String>();
		for (WebElement trains : trainNames) {
			trainnames.add(trains.getText());
		}
			System.out.println(trainnames);
			
		System.out.println("---------------------------------------------------------------");
		
		Set<String> uniquetrains = new HashSet<String>();
		for (WebElement uniques : trainNames) {
		uniquetrains.add(uniques.getText());

		}
		System.out.println(uniquetrains.size());
			System.out.println("The unique names of trains removing Duplicates: " + uniquetrains);
		}
}
