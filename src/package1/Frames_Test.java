package package1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Frames_Test {
	public WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.get("http://jqueryui.com/");
	  driver.findElement(By.linkText("Autocomplete")).click();
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
	  driver.findElement(By.id("tags")).sendKeys("Selenium");
	  
	  driver.switchTo().defaultContent();
	  driver.findElement(By.linkText("Draggable")).click();
	  Thread.sleep(4000);
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
