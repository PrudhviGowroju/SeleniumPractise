package Udemy.Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// https://rahulshettyacademy.com/loginpagePractise/

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.name("password")).sendKeys("learning");
		
		driver.findElement(By.xpath("//span[text()=' User']")).click();
		
		WebElement alertOkayBtn = driver.findElement(By.xpath("//button[@id='okayBtn']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(alertOkayBtn));
		
		alertOkayBtn.click();
		
		//driver.switchTo().alert().accept();
		
		WebElement drop = driver.findElement(By.xpath("//select[@class='form-control']"));
		
		Select dropdown = new Select(drop);
		
		List<WebElement> listDrops = dropdown.getOptions();
		
		for(WebElement i : listDrops) {
		
			System.out.println(i.getText());
			
		}
		
		dropdown.selectByVisibleText("Student");
		
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		
		WebElement checkoutButton = driver.findElement(By.cssSelector(".nav-link.btn.btn-primary"));
		
		wait.until(ExpectedConditions.visibilityOf(checkoutButton));
		
		List<WebElement> addproducts = driver.findElements(By.cssSelector(".btn.btn-info"));
		
		for(WebElement i : addproducts) {
			
			i.click();
		}
		
		checkoutButton.click();
		
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		WebElement purchaseButton = driver.findElement(By.cssSelector(".btn.btn-success.btn-lg"));
		
		wait.until(ExpectedConditions.visibilityOf(purchaseButton));
		
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		
		driver.findElement(By.xpath("//a[text()='term & Conditions']")).click();
		
		WebElement closeAlert = driver.findElement(By.xpath("//button[text()='Close']"));
		
		//wait.until(ExpectedConditions.visibilityOf(closeAlert));
		
		driver.switchTo().alert().accept();
		
		purchaseButton.click();
		
		
		
		Thread.sleep(8000);		
		driver.quit();
	}

}
