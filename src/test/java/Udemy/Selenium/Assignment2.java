package Udemy.Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// https://rahulshettyacademy.com/angularpractice/

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input")).sendKeys("Prudhvi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input")).sendKeys("Pannati.Shrikanth@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("1234567890");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']/preceding-sibling::input")).click();
		Thread.sleep(2000);
		WebElement staticDropDown = driver.findElement(By.xpath("//label[text()='Gender']/parent::div/child::select"));
		Thread.sleep(2000);
		Select dropDown = new Select(staticDropDown);
		
		List<WebElement> dropDownOptions = dropDown.getOptions();
		Thread.sleep(2000);
		dropDown.selectByIndex(1);
		
		for (WebElement i : dropDownOptions) {
			
			System.out.println(i.getText());
			
		}
		
		driver.findElement(By.xpath("//label[text()='Student']/preceding-sibling::input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Date of Birth']/following-sibling::input")).sendKeys("08-08-1999");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
	
	}

}
