package Udemy.Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		// https://the-internet.herokuapp.com/windows
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windows= driver.getWindowHandles();
		
		Iterator<String> itr = windows.iterator();
		
		String parentWindow = itr.next();
		
		String childWindow = itr.next();
		
		driver.switchTo().window(childWindow);
		
		String childText = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
		
		System.out.println(childText);
		
		driver.switchTo().window(parentWindow);
		
		String parentText = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
		
		System.out.println(parentText);
		
		Thread.sleep(3000);
		driver.quit();

	}

}
