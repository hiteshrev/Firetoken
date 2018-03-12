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
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class EventPage {
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
	public void AddEvent() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Events")).click();
		driver.findElement(By.linkText("Add New Event")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).sendKeys("San Diego Bay Wine + Food Fest");
		driver.findElement(By.id("location")).sendKeys("Austin, TX, United States");
		driver.findElement(By.id("zipcode")).sendKeys("78652");
		driver.findElement(By.id("title")).sendKeys("The Chefs Group");
		WebElement uploading=driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[5]/a/img"));
	    uploading.click();		    	   
	    driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[5]/a/img"));
		StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Downloads\\1499702965662.png");
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
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div/select/option[2]")).click();
		Thread.sleep(2000);
		WebElement Youtube=driver.findElement(By.id("video_id"));
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Youtube.sendKeys("6e75vQFbSac");
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div/div/span/button")).click();
		Thread.sleep(3000);
	   WebElement body = driver.findElement(By.id("description-text_ifr"));
	     body.sendKeys("Charleston Food + Wine Festival celebrates Charleston, South Carolina’s bounty and delectable culinary culture. This food festival raises money for scholarships for those studying culinary and hospitality professions. This five-day festival is complete with a Culinary Village that features chefs, winemakers, and authors. You’ll also find demonstrations, tastings, book signings, music and much more. The New Orleans Wine & Food Experience welcomes over 10,000 gastronomes. This epicurean celebration also supports culinary education, with 100 percent of the proceeds going to support various different establishments. During the four-day event, guests can visit participating restaurants who serve special menus; sample an impressive array of wines from all around the world, attend seminars and enjoy the Royal Street Stroll.");
	     driver.switchTo().defaultContent();
	     Thread.sleep(3000);
	     driver.findElement(By.id("datepicker_start")).sendKeys("2019-8-26");
	     Thread.sleep(2000);
	     driver.findElement(By.id("start_time")).sendKeys("07:00");
	     Thread.sleep(2000);
	     driver.findElement(By.id("datepicker_end")).sendKeys("2019-8-26");
	     Thread.sleep(2000);
	     driver.findElement(By.id("end_time")).sendKeys("07:00");
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[9]/div/button")).sendKeys("Cooking Class");
	     driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[9]/div/button")).sendKeys("Pot Luck");
	     //driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[9]/div/button")). click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[10]/div/button")).sendKeys("Gluten Free");
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Save")).click();
	   	     String PageTitle = driver.getTitle();
			System.out.println("Page title: - "+PageTitle);
			Assert.assertTrue(PageTitle.equalsIgnoreCase("AddEvent"), "Page title doesn't match");
			
			
	}
	
}
