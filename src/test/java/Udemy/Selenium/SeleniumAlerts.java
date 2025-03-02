package Udemy.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlerts {

	public static void main(String[] args) throws InterruptedException {
		// https://rahulshettyacademy.com/AutomationPractice/
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//legend[text()='Switch To Alert Example']/following-sibling::input[@id='name']")).sendKeys("India");
		
		driver.findElement(By.xpath("//legend[text()='Switch To Alert Example']/following-sibling::input[@id='alertbtn']")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//legend[text()='Switch To Alert Example']/following-sibling::input[@id='confirmbtn']")).click();
	
		System.out.println(driver.switchTo().alert().getText());
	
		driver.switchTo().alert().dismiss();
			
		Thread.sleep(2000);
		driver.quit();
		
	}

}
