package upbeatProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditEvent {
	
	private WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	@Test(priority=1)	
		public void Login() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			String appUrl = "http://dev.theupbeetkitchen.com/";
			driver.get(appUrl);
			Thread.sleep(2000);
			driver.findElement(By.id("close_tour")).click();
			driver.manage().window().maximize();
			// For shift Join to Login Button
			/*JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("$('#signin_div > .shw_div').trigger('click')");*/
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("customLogin")).click();
			driver.findElement(By.id("ID")).sendKeys("datatesting266@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(3000);
		    String PageTitle = driver.getTitle();
			System.out.println("Page title: - "+PageTitle);
			Assert.assertTrue(PageTitle.equalsIgnoreCase("My Account"), "Page title doesn't match");
			}
	
	@Test(priority=2)	
	public void EditDetails()throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Events")).click();
		driver.findElement(By.xpath("//*[@id='page_block_']/div/div[2]/div[1]/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page_block_1373']/div/div[2]/div[3]/div[1]/div/div[1]/div[3]/a[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("datepicker_start")).clear();
	     driver.findElement(By.id("datepicker_start")).sendKeys("2019-8-27");
	     Thread.sleep(2000);
	     driver.findElement(By.id("start_time")).clear();
	     driver.findElement(By.id("start_time")).sendKeys("5:00");
	     Thread.sleep(2000);
	     driver.findElement(By.id("datepicker_end")).clear();
	     driver.findElement(By.id("datepicker_end")).sendKeys("2019-8-30");
	     Thread.sleep(2000);
	     driver.findElement(By.id("end_time")).clear();
	     driver.findElement(By.id("end_time")).sendKeys("09:00");
	     Thread.sleep(2000);
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Save")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Recipe's")).click();
	     Thread.sleep(3000);
		driver.findElement(By.linkText("Reviews")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page_block_1373']/div/div[2]/div[3]/div[1]/div/div[1]/div[3]/a[2]/img")).click();
		Thread.sleep(2000);
	 	Alert alert = driver.switchTo().alert();
	 	alert.accept();
	 	Thread.sleep(2000);
		driver.findElement(By.id("customLogout")).click();
		driver.quit();
		
	}
}
	