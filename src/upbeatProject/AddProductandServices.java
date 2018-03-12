package upbeatProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddProductandServices {

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
			driver.findElement(By.id("ID")).sendKeys("testingrevin@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
	}
	@Test(priority=2)
	public void Productupload ()throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='customWelcome Chef Seinth Parker!']")).click();
		if (driver.findElement(By.xpath("//*[@id='cookProfileInfo']/div[2]/div[3]/div[1]/div[2]/a" )).isDisplayed())
		{
			driver.findElement(By.xpath("//*[@id='cookProfileInfo']/div[2]/div[3]/div[1]/div[2]/a")).click();
		}
		Thread.sleep(2000);
			driver.findElement(By.id("coursesPurchasedPage1")).click();
			driver.findElement(By.linkText("Add Products/Services")).click();
			driver.findElement(By.xpath("//*[@id='page_block_1378']/div/div[2]/div[1]/ul/li[4]/div/div/span[2]")).click();
		//	driver.findElement(By.xpath("//*[@id='page_block_1378']/div/div[2]/div[1]/ul/li[3]/input")).sendKeys("10");
            driver.findElement(By.id("title")).sendKeys("Your Partner at the Table and Beyond");
            WebElement uploading=driver.findElement(By.xpath("//*[@id='editCourseMainPhoto']/a/img"));
            uploading.click();		    	   
            driver.findElement(By.xpath("//*[@id='editCourseMainPhoto']/a/img"));
        	StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Downloads\\Dr-Legumes.jpg");
        	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        	Robot robot = new Robot();
        	robot.keyPress(KeyEvent.VK_CONTROL);
        	robot.keyPress(KeyEvent.VK_V);
        	robot.keyRelease(KeyEvent.VK_V);
        	robot.keyRelease(KeyEvent.VK_CONTROL);
        	robot.keyPress(KeyEvent.VK_ENTER);
        	robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
        	Thread.sleep(2000);
        	//Add youtube video...
        	driver.findElement(By.xpath("//*[@id='page_block_1378']/div/div[2]/div[2]/div/div[5]/div/select/option[2]")).click();
        	Thread.sleep(2000);
        	WebElement Youtube=driver.findElement(By.id("video_id"));
        	driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
        	Thread.sleep(2000);
        	Youtube.sendKeys("CgjfzLMmGV0");
        	 Thread.sleep(4000);        	 
        	 driver.findElement(By.xpath("//*[@id='page_block_1378']/div/div[2]/div[2]/div/div[5]/div/div/span/button")).click();
        	 Thread.sleep(2000);
        	 WebElement body = driver.findElement(By.id("description-text_ifr"));
             body.sendKeys("Lots of companies over promise and under deliver. At The Subdus Group, we are the complete opposite, we over deliver week after week,  providing you with great products and our personalized involvement are more than just words… it’s what we do. We only source the best products from farmers and exporters who share our passion for Truffles. That way, you know you’re receiving the highest quality possible. “Good enough” is just not an option for us. Truffles are the diamonds of the kitchen and we care about every truffle, every chef and every client who enjoys them.");
             driver.switchTo().defaultContent();
             Thread.sleep(3000);
             driver.findElement(By.linkText("Save")).click();
             Thread.sleep(3000);
             if (driver.findElement(By.id("customWelcome Chef Seinth Parker!")).isDisplayed())
     		{
     			driver.findElement(By.id("customWelcome Chef Seinth Parker!")).click();
     		}
             driver.findElement(By.xpath("//*[@id='cookProfileInfo']/div[2]/div[8]/div[2]/div/div[1]/ul/li/div/a")).click();     			
               }
	@Test(priority=3)
	public void EditProductServices() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='Main-1']/div[1]/div[1]/a[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page_block_1378']/div/div[2]/div[1]/ul/li[4]/div/div/span[1]")).click();
		driver.findElement(By.xpath("//*[@id='page_block_1378']/div/div[2]/div[1]/ul/li[3]/input")).clear();
		driver.findElement(By.xpath("//*[@id='page_block_1378']/div/div[2]/div[1]/ul/li[3]/input")).sendKeys("10");
		 driver.findElement(By.linkText("Save")).click();
		 if (driver.findElement(By.id("customWelcome Chef Seinth Parker!")).isDisplayed())
  		{
  			driver.findElement(By.id("customWelcome Chef Seinth Parker!")).click();
  		}
		
		 new Actions(driver);
			((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
			Thread.sleep(3000L);
		  driver.findElement(By.id("customLogout")).click();
		   driver.close();
		  
		
	}
	
	
}
