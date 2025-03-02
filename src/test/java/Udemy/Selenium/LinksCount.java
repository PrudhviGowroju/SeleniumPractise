package Udemy.Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCount {

	public static void main(String[] args) throws InterruptedException {
		// links count - will have a tag "a" -- qaclickacademy.com/practice.php
		// stale element not found - bcz its going to other page as we move to next page on each link click)
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG")); //limiting web driver scope
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//3
		
		WebElement columnOneDriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(columnOneDriver.findElements(By.tagName("a")).size());
		
		//create a mini driver - driver subset 
		
		//4 click on the links (dynamic elements can be handled well) 
		
		//problem : once we click on any link it will navigate to next window where we can't find the element 
		// so for that reason we will be clicking using ctrl + click - so that it opens in a new window		
		
		for(int i=0 ; i<=columnOneDriver.findElements(By.tagName("a")).size(); i++) {
			
			String clickon = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			columnOneDriver.findElements(By.tagName("a")).get(i).sendKeys(clickon);
			
			Thread.sleep(1000);
			
			Set<String> abc = driver.getWindowHandles();
			
			Iterator<String> it = abc.iterator();
			
			while(it.hasNext()){
				
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
				
			}
			
		}
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
