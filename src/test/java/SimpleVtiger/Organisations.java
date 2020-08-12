package SimpleVtiger;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Organisations 
{
	@Test
	public void Organisations() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","../SeleniumProject/DriverExe/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");//read data from property file
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("manager");
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class=\"button\"]/input[@value=\"Login\"]")).click();
		//click on organisations
		driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"]/a[text()=\"Organizations\"]")).click();
		//click on create organisations
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//td[text()=\"Organization Name 			\"]/following::td/input[@name=\"accountname\"]")).sendKeys("vivo v6");
		driver.findElement(By.xpath("//img[@title=\"Select\"]")).click();

		Set<String> ids=driver.getWindowHandles();
		Iterator<String>i =ids.iterator();
		String pid=i.next();
		String cid=i.next();
		driver.switchTo().window(cid);
		driver.findElement(By.xpath("//tr/td/div/table/tbody/tr[3]/td/a")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.switchTo().window(pid);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		//WebElement organization=driver.findElement(By.xpath("//a[text()=\"One Plus 8\"]"));
		//organization.click();
		//System.out.println(organization.getText());
	}

}
