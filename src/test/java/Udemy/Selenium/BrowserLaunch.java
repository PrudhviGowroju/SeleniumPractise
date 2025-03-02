package Udemy.Selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class BrowserLaunch {
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
				
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		BrowserLaunch bl = new BrowserLaunch();
		String password = bl.getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(3000);
		
		driver.findElement(By.id("inputUsername")).sendKeys("Prudhvi");
		
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		
		driver.findElement(By.cssSelector("button.signInBtn")).click();
		
		String actualResult =driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText();
		
		System.out.println(actualResult);
		
		Assert.assertEquals(actualResult, "You are successfully logged in.");
			
		Thread.sleep(3000);
		driver.quit();

	}
	
	public String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		
		String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		System.out.println(passwordText);
		//Please use temporary password 'rahulshettyacademy' to Login.
		
		String [] passArray = passwordText.split("'");
		
		String[] passArray2 = passArray[1].split("'");
		
		String password =  passArray2[0];
		
		System.out.println(password);
		
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		
		return password;
		
		
	}

}
