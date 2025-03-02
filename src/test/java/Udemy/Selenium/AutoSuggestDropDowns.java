package Udemy.Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDowns {

	public static void main(String[] args) throws InterruptedException {
		// https://rahulshettyacademy.com/dropdownsPractise/
		/*
		 * Unique link to open lecture directly:

Have a copy of below link for Quick view of this video at later time
https://www.udemy.com/selenium-real-time-examplesinterview-questions/learn/v4/t/lecture/2761068

*********************************************************************************************************************
Have a question? Post it in discussion board
https://www.udemy.com/selenium-real-time-examplesinterview-questions/learn/v4/questions
		 */

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		Thread.sleep(2000);
		
		List <WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India")) {
				System.out.println(option.getText());
				option.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
