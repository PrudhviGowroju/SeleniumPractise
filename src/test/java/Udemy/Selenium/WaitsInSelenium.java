package Udemy.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsInSelenium {

	public static void main(String[] args) throws InterruptedException {
		// Error: no such element: Unable to locate element - to handle that we use waits concept in selenium 
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String [] selectProduct = {"Cauliflower","Cucumber","Walnuts","Onion"};
		
		System.out.println(selectProduct.length);
		
		Sendingproductstocart sp= new Sendingproductstocart();
		
		sp.sendProductsToCart(driver, selectProduct);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		if(w.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.promoInfo"),"Code applied ..!"))) {
			
			System.out.println("Test passed with coupon applied");
			
		}
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
