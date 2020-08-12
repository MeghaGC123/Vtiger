import java.awt.Point;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExe {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","../VTiger/Drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.in");
		///Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement mobiles=driver.findElement(By.xpath("//h2[text()=\"Up to 40% off | Mobiles and accessories\"]"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//scroll to given element
		js.executeScript("arguments[0].scrollIntoView();", mobiles);
		Thread.sleep(3000);
		//click on element
		js.executeScript("arguments[0].click();",mobiles);
 

	}

}

