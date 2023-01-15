package task1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scenario2_TC {
	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		
		// openeing today's deals 
		
		driver.navigate().to("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");	
		
		// settin the resolution 
		
		Dimension dem = new Dimension(1024,768);
		driver.manage().window().setSize(dem);
	}
	
	@Test
	public void sss() {
		
		// selecting the headphones and grocery from the left side filters
		
		WebElement grocery = driver.findElement(By.xpath("/html/body/div[1]/div[21]/div/div/div/div[2]/div[2]/span[3]/ul/li[18]/label"));
		grocery.click();
		
		WebElement headphones = driver.findElement(By.xpath("/html/body/div[1]/div[21]/div/div/div/div[2]/div[2]/span[3]/ul/li[20]/label"));
		headphones.click();
		
		// choosing the "10% off or more" from the discount filter
		
		WebElement discount = driver.findElement(By.xpath("/html/body/div[1]/div[21]/div/div/div/div[2]/div[2]/span[6]/ul/li[2]/div/a/span"));
		discount.click();
		
		// navigating to third page
		
		WebDriverWait wait= (new WebDriverWait(driver, 10));
		WebElement third_page = driver.findElement(By.xpath("/html/body/div[1]/div[21]/div/div/div/div[3]/div/ul/li[7]/a"));
		wait.until(ExpectedConditions . elementToBeClickable(third_page));
		third_page.click();
		third_page.click();
		
		// // navigating to fourth page
		
		WebElement fourth_page = driver.findElement(By.xpath("/html/body/div[1]/div[21]/div/div/div/div[3]/div/ul/li[5]/a"));
		fourth_page.click();
		
		// select an item
		
		WebElement product = driver.findElement(By.cssSelector("div.DealContent-module__truncate_sWbxETx42ZPStTc9jwySW"));
		product.click();
		
		// adding the item to cart 
		
		WebElement add_to_cart_btn = driver.findElement(By.cssSelector("a.a-button-text a-text-left"));
		add_to_cart_btn.click();	
		
		
	}

	
	
	@AfterTest
	public void close() {
		driver.quit();
	}


}
