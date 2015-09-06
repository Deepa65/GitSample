package package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Facebook {
	public WebDriver wdriver;
	public EventFiringWebDriver driver;
	
	@Test
	public void testFrames_Test() throws Exception {
		//open application
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("emailofuser@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("password");
		driver.findElement(By.id("u_0_1")).sendKeys("FirstName");
		driver.findElement(By.id("u_0_3")).sendKeys("LastName");
		driver.findElement(By.id("u_0_5")).sendKeys("myemail@gmail.com");
		driver.findElement(By.id("u_0_8")).sendKeys("myemail@gmail.com");
		driver.findElement(By.id("u_0_a")).sendKeys("passwordofuser");
		
		Thread.sleep(3000);

	}
	@BeforeClass
	public void beforeClass() {
		wdriver = new FirefoxDriver();
		driver = new EventFiringWebDriver(wdriver);
		MyListner l = new MyListner();
		driver.register(l);
		//maximize window
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		//quit window
		driver.quit();
	}

}
