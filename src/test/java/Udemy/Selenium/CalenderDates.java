package Udemy.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderDates {

	public static void main(String[] args) throws InterruptedException {
		//https://rahulshettyacademy.com/dropdownsPractise/
		// //a[@class='ui-state-default ui-state-highlight']

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		/*driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		
		driver.findElement(By.xpath("//a[text()=' Vijayawada (VGA)']")).click();
		Thread.sleep(2000);	
		//
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[text()=' Hyderabad (HYD)']")).click();
		
		//select present date 
		
		//driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		
		/*driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		System.out.println(driver.findElement(By.cssSelector(".ui-state-active")).getText());
		
		//Assert.assertEquals(driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).getText(), "5")
		//not selecting date have to work on this*/
	
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			
			System.out.println("its enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
