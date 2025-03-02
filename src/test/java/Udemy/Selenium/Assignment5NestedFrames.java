package Udemy.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5NestedFrames {

	public static void main(String[] args) throws InterruptedException {
		//https://the-internet.herokuapp.com/nested_frames 
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		driver.quit();		
		

	}

}
