package upbeatProject;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BuyProductandServices {
	
	private WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	@Test(priority=1)	

		public void Login() throws InterruptedException, AWTException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			String appUrl = "https://dev.theupbeetkitchen.com/";
			driver.get(appUrl);
			Thread.sleep(2000);
			driver.findElement(By.id("close_tour")).click();
			driver.manage().window().maximize();
			// For shift Join to Login Button
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("$('#signin_div > .shw_div').trigger('click')");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("ID")).sendKeys("sumit@revinfotech.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
	}
	@Test(priority=2)
	public void UserSearching() throws InterruptedException{
	driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Connect")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='connect-form']/div/input[2]")).clear();
	driver.findElement(By.xpath("//*[@id='connect-form']/div/input[2]")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.id("srch")).sendKeys("seinth");
	driver.findElement(By.id("connect-search-btn")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='2477']/div[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='cookProfileInfo']/div[2]/div[8]/div[2]/div/div[1]/ul/li/div/a/div[2]/img")).click();
	driver.findElement(By.xpath("//*[@id='paypal_form']/input[8]")).click();
	
		}
	@Test(priority=3)
	public void BuyProduct() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='loadLogin']")).click();
		 driver.findElement(By.id("login_email")).clear();
		 WebElement we = driver.findElement(By.id("login_email"));
				  we.clear();
			    we.sendKeys("aman-buyer@revinfotech.com");
			    we = driver.findElement(By.id("login_password"));
			    we.sendKeys("india@123");
			    we =driver.findElement(By.name("login.x")); 
			    we.click();
			    Thread.sleep(5000);
			    if (driver.findElement(By.id("continue")).isDisplayed())
				{
					driver.findElement(By.id("continue")).click();
				}
			    Thread.sleep(5000);
			    driver.findElement(By.id("customLogout")).click();
				  driver.close();
			    
			    
	}
}
