package SimpleVtiger;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Contacts {

	@Test
	public void contacts()
	{
		System.setProperty("webdriver.gecko.driver","../SeleniumProject/DriverExe/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("manager");
		driver.findElement(By.xpath("//div[@class=\"button\"]/input[@value=\"Login\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.xpath("//td[text()=\"Last Name						\"]/following::input[@name=\"lastname\"]")).sendKeys("xyz");
		driver.findElement(By.xpath("(//img[@title=\"Select\"])[1]")).click();
		Set<String> ids=driver.getWindowHandles();
		System.out.println(ids);
		Iterator<String>i =ids.iterator();
		String pid=i.next();
		String cid=i.next();
		driver.switchTo().window(cid);
		driver.findElement(By.xpath("//tr/td/div/table/tbody/tr[5]/td/a")).click();
		//Thread.sleep(3000);
		driver.switchTo().window(pid);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
	}

}
