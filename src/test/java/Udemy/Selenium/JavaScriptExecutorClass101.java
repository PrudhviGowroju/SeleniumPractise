package Udemy.Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorClass101 {

	public static void main(String[] args) throws InterruptedException {
		// www.rahulshettyacademy.com/AutomationPractise/
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
		
		driver.get("http://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		
		/*.tableFixHead td:nth-child(4) -CSS path

		//div[@class='tableFixHead']/descendant::tr/td[4]- xpath*/
		
		
		List<WebElement>values = driver.findElements(By.xpath("//div[@class='tableFixHead']/descendant::tr/td[4]"));
		
		int no_of_values = values.size();
	
		System.out.println(no_of_values);
		
		int sum=0;
		
		for(int i =0 ; i<no_of_values; i++) {
			
			sum = sum + Integer.parseInt(values.get(i).getText());
			
		}
		
		System.out.println("Sum of values are : "+ sum);
		
		int total = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
	//Debug and watch then copy the path and paste in expression to have customised value
		
		Assert.assertEquals(sum, total);
		
		Thread.sleep(2000);
		driver.quit();
		

	}

}
