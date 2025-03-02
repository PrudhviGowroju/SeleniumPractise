package Udemy.Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		// https://rahulshettyacademy.com/loginpagePractise/#

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String>ids= driver.getWindowHandles();
		
		Iterator<String>it = ids.iterator();
		
		String parentId= it.next();
		
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		String emailId= driver.findElement(By.xpath("//p[text()='Please email us at ']")).getText().split("at")[1].trim().split(" ")[0];
		
		System.out.println(emailId);
		
		driver.switchTo().window(parentId);
		
		driver.findElement(By.cssSelector("#username")).sendKeys(emailId);
		
		Thread.sleep(1000);
		driver.quit();
		
	}

}
