package Asserts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAndSoftAssert {
	
	@Test
	public void getTitle() throws InterruptedException
	{

		System.setProperty("webdriver.gecko.driver","../VTiger/Drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title=driver.getTitle();
		String exp="Google";
		WebElement searchbox=driver.findElement(By.xpath("//input[@id=\"realbox\"]"));
		
		//Hard assert
		Assert.assertEquals(title,exp, "Title is NOT Macthing");
		Assert.assertTrue(searchbox.isDisplayed());
		//Thread.sleep(2000);
		searchbox.sendKeys("Selenium");

	}
	
	

}
