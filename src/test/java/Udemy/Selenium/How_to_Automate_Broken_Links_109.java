package Udemy.Selenium;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class How_to_Automate_Broken_Links_109 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		
		// rahulshettyacademy.com/AutomationPractice
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("http://www.rahulshettyacademy.com/AutomationPractice/");
		
		List <WebElement> links = driver.findElements(By.xpath("//li/a"));
		SoftAssert a = new SoftAssert();
		
		for (WebElement link : links) {
			
			String url = link.getAttribute("href");
			
				HttpURLConnection httpURLCon = (HttpURLConnection) new URL(url).openConnection();
				httpURLCon.setConnectTimeout(3000);
				httpURLCon.connect();
				
				int respCode = httpURLCon.getResponseCode();
				System.out.println(respCode);
				
				
				//This is Hard assertion test fails after this so we are trying to include soft assertions
				//Assert.assertTrue(respCode >400, url + "-" + httpURLCon.getResponseMessage()); 
				
				a.assertTrue(respCode<400,  url + "-" + httpURLCon.getResponseMessage()); //This is soft assert 
			
				
				/*
				
				if (respCode == 200) {
					System.out.println(url + "-" + httpURLCon.getResponseMessage());
				}
				else {
					System.out.println(url+ "- " + httpURLCon.getResponseMessage() +"is a broken link");
				}
				*/
		}
		a.assertAll() ;// this will report all the failures 
		
		Thread.sleep(3000);
		driver.quit();

	}

}
