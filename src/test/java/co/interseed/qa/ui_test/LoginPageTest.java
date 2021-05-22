package co.interseed.qa.ui_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void SetUpEnvironment() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kanis\\Documents\\Legit Stuff\\NUS\\YSI SEA\\Java Extras\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--start-fullscreen");
		this.driver = new ChromeDriver(options);
		driver.get("https://app.interseed.co");
		this.wait = new WebDriverWait(driver, 5);
	}
	
	@AfterMethod
	public void ShutDown() {
		this.driver.close();
	}
	
	@Test
	public void LoginTest() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("asdasd@gmail.com");
		driver.findElement(By.id("password")).sendKeys("asdasdasd");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait.until(ExpectedConditions.urlToBe("https://app.interseed.co/landscapes"));
		String expectedLoginUrl = "https://app.interseed.co/landscapes";
		String loginUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginUrl, expectedLoginUrl);		
	}
	
}