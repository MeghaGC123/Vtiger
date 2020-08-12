package SimpleVtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Campaign
{
	@Test
	public void Campaign()
	{
	System.setProperty("webdriver.gecko.driver","../SeleniumProject/DriverExe/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("manager");
		driver.findElement(By.xpath("//div[@class=\"button\"]/input[@value=\"Login\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"More\"]")).click();
		driver.findElement(By.xpath("//td[@class=\"tabSelected\"]/a[text()=\"Campaigns\"]")).click();

}
}