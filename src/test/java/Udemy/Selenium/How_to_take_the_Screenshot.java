package Udemy.Selenium;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils; // downloaded manually from apache commons io
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class How_to_take_the_Screenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// by casting our driver object to take screen shot object
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("http://google.com");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File ("C:\\Users\\prudh\\Pictures\\Screenshots\\Automation screenshots\\1.png"));
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
