package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task2_TC {
	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		
		// openning the website 
		
		driver.navigate().to("https://ksrtc.in/oprs-web/guest/home.do?h=1");	
		
		// setting the resolution 
		
		Dimension dem = new Dimension(1024,768);
		driver.manage().window().setSize(dem);
		
	}
	
	@Test
	public void bus_reservation ()
	{
	
		// Choose the following ((from "CHIKKAMAGALURU" to "BENGALURU”)) from the popular routes
		
		WebDriverWait wait= (new WebDriverWait(driver, 10));
		WebElement destination = driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a"));
		wait.until(ExpectedConditions . elementToBeClickable (destination));
		destination.click();
		
		// choosing the dates 
		
		WebElement returnDate = driver.findElement(By.id("txtReturnJourneyDate"));
		returnDate.click();
		WebElement theDate = driver.findElement(By.cssSelector("a.ui-state-default"));
		theDate.click();
		
		WebElement departureDate = driver.findElement(By.id("txtJourneyDate"));
		departureDate.click();
		WebElement depDate = driver.findElement(By.cssSelector("a.ui-state-default"));
		depDate.click();
		
		// Clicking “Search for bus”
		WebElement bus_search = driver.findElement(By.cssSelector("button.btn.btn-primary.btn-lg.btn-block.btn-booking"));
		bus_search.click();
		
		// Select a seat
		
		WebElement seat = driver.findElement(By.id("SrvcSelectBtnForward0"));
		seat.click();
		
		//	Choose the boarding point and dropping point
		
		WebElement boarding_point = driver.findElement(By.id("Forwardboarding-tab"));
		boarding_point.click();
		
		WebElement seat_number = driver.findElement(By.cssSelector("span.seatNumber"));
		seat_number.click();
		
		WebElement dropping_point = driver.findElement(By.id("Forwarddroping-tab"));
		dropping_point.click();
		
		WebElement the_point = driver.findElement(By.id("Forward16"));
		the_point.click();
		
		// Filling the “Customer” and “Passenger” details 
		
		WebElement customer_details = driver.findElement(By.id("Forwardprofile-tab"));
		customer_details.click();
		
		WebElement mobile_num = driver.findElement(By.id("mobileNo"));
		mobile_num.sendKeys("6789125987");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("@xyz");
		
		WebElement passenger_name = driver.findElement(By.id("passengerNameForward0"));
		passenger_name.sendKeys("JohnSmith");
		
		WebElement gender_list = driver.findElement(By.id("genderCodeIdForward0"));
		Select selected_gender = new Select(gender_list);
		selected_gender.selectByVisibleText("MALE");
		
		WebElement passenger_age = driver.findElement(By.id("passengerAgeForward0"));
		passenger_age.sendKeys("24");
		
		WebElement concession_list = driver.findElement(By.id("concessionIdsForward0"));
		Select conSelect = new Select(concession_list);
		selected_gender.selectByVisibleText("GENERAL PUBLIC");
		
		WebElement country = driver.findElement(By.id("nationalityForward0"));
		Select selected_country = new Select(country);
		selected_gender.selectByVisibleText("INDIA");

		// booking
		
		WebElement booking = driver.findElement(By.id("BookRetBtn"));
		booking.click();
			
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
