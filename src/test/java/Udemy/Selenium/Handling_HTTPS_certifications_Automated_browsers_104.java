package Udemy.Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Handling_HTTPS_certifications_Automated_browsers_104 {

	public static void main(String[] args) throws InterruptedException {
		// "https://expired.badssl.com/"
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); // Behaviour of the options is set 
		
		WebDriver driver = new ChromeDriver(options); //We need to pass it into the Class argument so the driver will learn the behaviour of it
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//Delete Session login - Click on any link it should redirect to login page - cookie will be like sessionKey
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}
