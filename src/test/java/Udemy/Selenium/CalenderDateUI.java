package Udemy.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderDateUI {

	public static void main(String[] args) throws InterruptedException {
		// https://rahulshettyacademy.com/seleniumPractise/#/offers
		// String variables to xpath 
		
		String monthNumber = "8";
		String date = "8";
		String year = "2024";
			
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.className("react-date-picker__inputGroup__year")).click();
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		
		Thread.sleep(3000);
		
		driver.quit();		
		

	}

}
