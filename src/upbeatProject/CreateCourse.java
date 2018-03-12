package upbeatProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateCourse {
	private WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@Test(priority = 1)
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
		//driver.findElement(By.id("customLogin")).click();
		driver.findElement(By.id("ID")).sendKeys("Sumit@revinfotech.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("loginButton")).submit();
		EditCourse();
		Thread.sleep(4000);
	}
@Test(priority = 2)
public void AddNewCourse() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.linkText("Learn"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Courses")).click();
		if (driver.findElement(By.linkText("Add New Course")).isDisplayed()){
			driver.findElement(By.linkText("Add New Course")).click();
		}
		driver.findElement(By.id("title")).sendKeys("CANADIAN LIVING COOKING CLASS");
		WebElement uploading = driver.findElement(By.xpath("html/body/div[3]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/a/img"));
		uploading.click();
		driver.findElement(By.xpath("html/body/div[3]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/a/img"));
		StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Downloads\\Bestie.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		//Add youtube video...
		driver.findElement(By.xpath("html/body/div[3]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div[1]/select/option[2]")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement Youtube=driver.findElement(By.id("video_id"));
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		Thread.sleep(5000);
		Youtube.sendKeys("YtzAFV2jdp8");
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[3]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div[1]/div/span/button")).click();
		Thread.sleep(4000);
		WebElement body = driver.findElement(By.id("description-text_ifr"));
		body.sendKeys("Thirty minutes to an hour before serving, combine the strawberries, balsamic vinegar, sugar, and pepper in a bowl. Set aside at room temperature. Place a serving of the strawberries in a bowl with a scoop of ice cream on top and dust lightly with lemon zest.");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[3]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[2]/div/div/span/input[2]")).sendKeys("a");
		Thread.sleep(2000);
		 driver.findElement(By.xpath("html/body/div[3]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[2]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("html/body/div[3]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[2]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		if (driver.findElement(By.linkText("Save")).isDisplayed()){
			driver.findElement(By.linkText("Save")).click();
		}
				}
@Test(priority = 3)
public void EditCourse() throws InterruptedException, AWTException {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement element = driver.findElement(By.linkText("Learn"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	driver.findElement(By.linkText("Courses")).click();
	driver.findElement(By.id("sort")).sendKeys("Latest");
	Thread.sleep(2000);
	driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/form/div[2]/div[1]/div/div/div[1]")).click();
	Thread.sleep(2000);
 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/form/div[2]/div[1]/div/div/div[2]/ul/li[1]/label/input")).click();
 driver.findElement(By.id("srch")).sendKeys("CANADIAN LIVING COOKING CLASS");
 driver.findElement(By.id("connect-search-btn")).click();
 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div/a/div[2]/img")).click();
 Thread.sleep(2000);
 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/a[1]/img")).click();
 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/ul/li[4]/div/div/span[1]")).click();
 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/ul/li[3]/input")).clear();
 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/ul/li[3]/input")).sendKeys("5");
 Thread.sleep(2000);
 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[1]/div[8]/a")).click();
 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[1]/div[7]/div[2]/div[2]/div/div/span/input[2]")).sendKeys("c");
	Thread.sleep(2000);
	 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[1]/div[7]/div[2]/div[2]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[1]/div[7]/div[2]/div[2]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
 if (driver.findElement(By.linkText("Save")).isDisplayed()){
		driver.findElement(By.linkText("Save")).click();
	}
}
@Test(priority = 4)
public void DeleteCourse() throws InterruptedException, AWTException {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement element = driver.findElement(By.linkText("Learn"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	driver.findElement(By.linkText("Courses")).click();
	driver.findElement(By.id("sort")).sendKeys("Latest");
	Thread.sleep(2000);
	driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/form/div[2]/div[1]/div/div/div[1]")).click();
	Thread.sleep(2000);
 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/form/div[2]/div[1]/div/div/div[2]/ul/li[1]/label/input")).click();
 driver.findElement(By.id("srch")).sendKeys("CANADIAN LIVING COOKING CLASS");
 driver.findElement(By.id("connect-search-btn")).click();
 driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div/a/div[2]/img")).click();
 Thread.sleep(2000);
 driver.findElement(By.xpath("//*[@id='Main-1']/div/div[1]/a[2]/img")).click();
 Thread.sleep(2000);
 driver.findElement(By.id("deleteThis")).click();
 Thread.sleep(2000);
 driver.findElement(By.id("customLogout")).click();
	Thread.sleep(2000);
	driver.close();
}
}