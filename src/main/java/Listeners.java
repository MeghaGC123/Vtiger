import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Listeners
{
	@Test
	public void title() throws Throwable
	{

		System.setProperty("webdriver.gecko.driver","../SeleniumProject/DriverExe/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title=driver.getTitle();
		String exp="Google";
		WebElement searchbox=driver.findElement(By.xpath("//input[@id=\"realbox\"]"));
		
		//Hard assert
		Assert.assertEquals(title,exp, "Title is NOT Macthing");
		Assert.assertTrue(searchbox.isDisplayed());
		Thread.sleep(2000);
		searchbox.sendKeys("selenium");
	}

}
