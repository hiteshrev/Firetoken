package upbeatProject;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GroupMemberLoginandDelete {
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
	driver.findElement(By.id("ID")).sendKeys("sumit1@revinfotech.com");
	driver.findElement(By.id("Password")).sendKeys("123456");
	driver.findElement(By.id("loginButton")).submit();
	Thread.sleep(2000);
	WebElement element =driver.findElement(By.linkText("Connect"));	 
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	driver.findElement(By.linkText("Groups")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='result_block']/div[2]/a/div[2]/img")).click();
	Thread.sleep(4000);
	driver.findElement(By.linkText("Members")).click();
	Thread.sleep(4000);
	driver.findElement(By.linkText("Recipe's")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("write_review")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id='review_form']/div/span[4]")).click();
	driver.findElement(By.id("review_message")).sendKeys("Hi !! Thanks for adding me");	
	Thread.sleep(2000);
	driver.findElement(By.id("send_review")).click();	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='join_grp']/img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='leave_grp']/img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='join_grp']/img")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("customLogout")).click();

	}
	@Test(priority=3)
	 public void DeleteGroup() throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.id("customLogin")).click();
	driver.findElement(By.id("ID")).sendKeys("HappyCustomers@theupbeetkitchen.com");
	driver.findElement(By.id("Password")).sendKeys("UpBeet@5075");
	driver.findElement(By.id("loginButton")).submit();
	Thread.sleep(2000);
	WebElement element =driver.findElement(By.linkText("Connect"));	 
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	driver.findElement(By.linkText("Groups")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='result_block']/div[2]/a/div[2]/img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[3]/div/img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[2]/div/ul/li[5]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='del_grp_btn']/img")).click();
	 Alert alert = driver.switchTo().alert();
	 	alert.accept();
	 	WebElement element1 =driver.findElement(By.linkText("Connect"));	 
		Actions action1 = new Actions(driver);
		action1.moveToElement(element1).build().perform();
		driver.findElement(By.linkText("Groups")).click();
		driver.findElement(By.id("customLogout")).click();
	
		driver.close();
	}}
