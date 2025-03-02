package Udemy.Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// 1. Select any check box 
		// 2. Grab the label of the selected checkbox //put into variable
		// 3. Select an option in dropdown. Here option to select should come from step 2 // Do not hard code text should come from step 2
		// 4. Enter the Step2 grabbed label text in Editbox 
		// 5. Click Alert and then Verify if text grabbed from Step 2 is present in the pop up message
		
		//https://rahulshettyacademy.com/AutomationPractice/
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//label/input[@id='checkBoxOption1']")).click();
		
		String checkBoxValue = driver.findElement(By.xpath("//label/input[@id='checkBoxOption1']")).getText();
		
		String correctedValue = checkBoxValue.trim();
		System.out.println(checkBoxValue);
		
		WebElement dropdown= driver.findElement(By.id("dropdown-class-example"));
		
		Select dropdownValues = new Select(dropdown);
		
		List<WebElement> dropdownnames = dropdownValues.getOptions();
		
		for(WebElement i : dropdownnames) {
			
			System.out.println(i.getText());
			
			if(i.getText()== correctedValue) {
				i.click();
			}
		}
		
		
		
		Thread.sleep(3000);
		driver.quit();
			

	}

}
