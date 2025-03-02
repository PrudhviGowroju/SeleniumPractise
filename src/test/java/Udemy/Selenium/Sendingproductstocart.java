package Udemy.Selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sendingproductstocart {

	public static void main(String[] args) throws InterruptedException {
		// Goal is add item to cart where ever the single product as element is present
		// in web page
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.manage().window().maximize();

		String [] selectProduct = {"Cauliflower","Cucumber","Walnuts","Onion"};
		
		System.out.println(selectProduct.length);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Sendingproductstocart sp= new Sendingproductstocart();
		
		sp.sendProductsToCart(driver, selectProduct);
		
		Thread.sleep(8000);
		
		driver.quit();
		
	}
	
	public void sendProductsToCart(WebDriver driver,String [] productsNeeded) {
		List<WebElement> allProducts = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < allProducts.size(); i++) {

			String productNames = allProducts.get(i).getText();
			String [] formattedName = productNames.split("-");
			String itemName = formattedName[0].trim();
			System.out.println(itemName);
			
			//as Arrays do not have the contains functionalty we are converting it into ArrayList 
			
			List selectedProductsList = Arrays.asList(productsNeeded);
		
			int j=0;
			
			if (selectedProductsList.contains(itemName)) {
				
				System.out.println("Selected items are : " + itemName);

				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				
				/*this has got a problem because as soon as you click on "ADD TO CART" it will change to "ADDED", 
				Hence it works in a dynamic way now we are changing it too static xpath*/

				/*break; // it should break other it will validate all the elements
				 * Here we can't use break statement as we need to search other product in the 
				 * Arryas as well 
				 * So instead we are using can fail the IF condition with java knowledge
				 * */
				
				j++;
				
				if(j==productsNeeded.length) {
					
					break;
				}
				
			}
		}
		
	}

}
