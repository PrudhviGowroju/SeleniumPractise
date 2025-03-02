package Udemy.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPractise {

	public static void main(String[] args) throws InterruptedException {
		// https://rahulshettyacademy.com/dropdownsPractise/
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select currencyDropdown = new Select(staticDropDown);
		
		currencyDropdown.selectByIndex(3);
		
		System.out.println(currencyDropdown.getFirstSelectedOption().getText());
		
		
		// looping for dropdowns -- yet to practise 
		//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		
		driver.findElement(By.xpath("//a[text()=' Vijayawada (VGA)']")).click();
		Thread.sleep(2000);	
		//
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[text()=' Hyderabad (HYD)']")).click();
		//a[text()=' Chennai (MAA)']
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		Thread.sleep(2000);	
		driver.quit();
		
		
	}

}
