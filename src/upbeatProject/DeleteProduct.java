package upbeatProject;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteProduct {
	private WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	@Test(priority=1)	

		public void Login() throws InterruptedException, AWTException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			String appUrl = "http://dev.theupbeetkitchen.com/";
			driver.get(appUrl);
			Thread.sleep(2000);
			driver.findElement(By.id("close_tour")).click();
			driver.manage().window().maximize();
			// For shift Join to Login Button
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("$('#signin_div > .shw_div').trigger('click')");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("ID")).sendKeys("testingrevin@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
			
	}
	
	@Test(priority=2)
	public void Productupload ()throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='customWelcome Chef Seinth Parker!']")).click();
		if (driver.findElement(By.xpath("//*[@id='cookProfileInfo']/div[2]/div[8]/div[2]/div/div[1]/ul/li/div/a/div[2]/img" )).isDisplayed())
		{
			driver.findElement(By.xpath("//*[@id='cookProfileInfo']/div[2]/div[8]/div[2]/div/div[1]/ul/li/div/a/div[2]/img")).click();
		}
		Thread.sleep(2000);
			driver.findElement(By.id("deleteThis")).click();
			driver.findElement(By.id("customLogout")).click();
			  driver.close();
			
			
	}
}


