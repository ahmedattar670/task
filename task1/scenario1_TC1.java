package task1;

import org.openqa.selenium.Dimension;

import static org.testng.Assert.assertEquals;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class scenario1_TC1 {

	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		
		// open the amazon link 
		
		driver.navigate().to("https://www.amazon.com/");	
		
		// setting the resolution 
		
		Dimension dem = new Dimension(1024,768);
		driver.manage().window().setSize(dem);
	}
	
	@Test
	public void add_to_cart ()
	{
		// typing car accessories in the search bar 
		
		WebElement search_bar = driver.findElement(By.id("twotabsearchtextbox"));
		search_bar.sendKeys("car accessories");
		search_bar.submit();
		
		// selecting the first item
		
		WebElement first_item = driver.findElement(By.cssSelector("span.a-size-base-plus.a-color-base.a-text-normal"));
		first_item.click();
		
		// adding the item to cart
		
		WebElement add_to_cart_btn = driver.findElement(By.id("add-to-cart-button"));
		add_to_cart_btn.click();
		
		// assertion that it was added to cart
		
		WebElement success = driver.findElement(By.cssSelector("span.a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold"));
		Assert.assertEquals("Added to Cart",success.getText() );	
		
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}


	
}
