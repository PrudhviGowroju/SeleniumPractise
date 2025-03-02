package Udemy.Selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceMultipleProductSelection {

	public static void main(String[] args) throws InterruptedException {
		// https://rahulshettyacademy.com/seleniumPractise/#/

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.manage().window().maximize();

		String[] selectProducts = { "Cauliflower", "Cucumber" };

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		List<WebElement> allProducts = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < allProducts.size(); i++) {

			String productName = allProducts.get(i).getText();

			/*
			 * Arrays wont have the capability to handle contains method so changing it to
			 * Array list
			 */
			/*
			 * Array takes less memory so we use for storing and to run we will be
			 * converting it into Array List
			 */
		List itemsNeededList = Arrays.asList(selectProducts); // Arrays to ArrayList

			if (itemsNeededList.contains(productName)) {

				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

				/*break; // it should break other it will validate all the elements
				 * Since we are using multiple products we can't use break statement so 
				 * instead we are writing a logic 
				 * 
				 * */
			}
		}

		Thread.sleep(3000);
		
		driver.quit();

	}

}
