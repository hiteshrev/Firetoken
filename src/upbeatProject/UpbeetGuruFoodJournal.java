package upbeatProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UpbeetGuruFoodJournal {
	private static WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	boolean check = true;

	@Test(priority = 1)
	public void UpbeetGuruLogin() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();
		String appUrl = "http://dev.theupbeetkitchen.com/";
		driver.get(appUrl);
		Thread.sleep(3000);
		driver.findElement(By.id("close_tour")).click();
		driver.manage().window().maximize();
		// For shift Join to Login Button
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("$('#signin_div > .shw_div').trigger('click')");
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.id("ID")).sendKeys("hiteshbali52.hb@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("loginButton")).submit();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void AddMeal() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By
				.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div[1]/div/div[1]/i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).sendKeys("Easy and healthy");
		Thread.sleep(2000);
		// put path to your image in a clipboard
		WebElement element = driver.findElement(By.xpath("//*[@id='food_form']/div[2]/div[1]/div[2]/div/i"));
		element.click();
		StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Pictures\\Weekly-Meal-Plan.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		driver.findElement(By.id("saveData")).click();
	}

	@Test(priority = 3)
	public void AddDeleteComment() throws InterruptedException, AWTException {
		// driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//*[@id='accordion']/div[1]/div[1]/i")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/ul/li[2]/label/span")).click();
		// Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[@id='addComment']/div/div[5]/i[1]"));
		element.click();
		StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Downloads\\artsfon.com-63613.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		driver.findElement(By.id("comment")).sendKeys("Hi!! Jason Methew! from this side");
		driver.findElement(By.id("comment")).sendKeys(Keys.ENTER);
		Thread.sleep(15000);
		driver.findElement(By
				.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div[1]/div/div[2]/div/p/a/i"))
				.click();
		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void AddUser() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id='accordion']/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("add_user_manually")).sendKeys("jaspreet@revinfotech.com");
		Thread.sleep(15000);
		driver.findElement(By.name("add_user")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
		Thread.sleep(2000);
				}
}