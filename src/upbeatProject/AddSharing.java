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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddSharing {
	private WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@Test(priority = 1)
	public void Login() throws InterruptedException {
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
		driver.findElement(By.id("ID")).sendKeys("HappyCustomers@theupbeetkitchen.com");
		driver.findElement(By.id("Password")).sendKeys("vhKP.xrj");
		driver.findElement(By.id("loginButton")).submit();
		Thread.sleep(2000);
		DeleteSharing();
		
	}
	@Test(priority = 2)
	public void AddNewSharing() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.linkText("Connect"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Sharing")).click();
		driver.findElement(By.id("add_btn_sharing")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Strawberries with Balsamic Vinegar");
		WebElement uploading = driver.findElement(By.xpath("//*[@id='editRecipeMainPhoto']/a/img"));
		uploading.click();
		driver.findElement(By.xpath("//*[@id='editRecipeMainPhoto']/a/img"));
		StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Downloads\\870636.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("credit")).sendKeys("http://dev.theupbeetkitchen.com");
		driver.findElement(By.id("credit-link")).sendKeys("http://dev.theupbeetkitchen.com");
		Thread.sleep(2000);
		WebElement body = driver.findElement(By.id("contentarea_ifr"));
		body.sendKeys("Thirty minutes to an hour before serving, combine the strawberries, balsamic vinegar, sugar, and pepper in a bowl. Set aside at room temperature. Place a serving of the strawberries in a bowl with a scoop of ice cream on top and dust lightly with lemon zest.");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement body1 = driver.findElement(By.id("contentarea1_ifr"));
		body1.sendKeys("Thirty minutes to an hour before serving, combine the strawberries, balsamic vinegar, sugar, and pepper in a bowl. Set aside at room temperature.");
		driver.switchTo().defaultContent();
		//Select Diet
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/ul/li[2]/a/label/input")).click();
		Thread.sleep(2000);
		//Select Category
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='category']")).sendKeys("Nutrition Nook");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div/input")).sendKeys("Jamie Oliver");
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.name("article_link")).sendKeys("https://dev.theupbeetkitchen.com/m/sharing");
		Thread.sleep(2000);
		driver.findElement(By.id("save_sharing_new")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
	}
	@Test(priority = 3)
	public void EditSharing() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.linkText("Connect"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Sharing")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("srch")).sendKeys("Strawberries with Balsamic Vinegar");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='connect-search-btn']/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='result_block']/div/a/div[2]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='icon06']/img")).click();
		Thread.sleep(3000);
		//Select & Edit Diet
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/ul/li[4]/a/label")).click();
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/ul/li[5]/a/label")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='category']")).sendKeys("Challenge");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div/input")).sendKeys("Sugar");
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		if (driver.findElement(By.id("edit_sharing_save")).isDisplayed()){
		driver.findElement(By.id("edit_sharing_save")).click();
		}
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	@Test(priority = 4)
	public void DeleteSharing() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.linkText("Connect"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Sharing")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("sort")).sendKeys("name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]/h4")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Diets']/ul/li[2]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Diets']/ul/li[4]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Diets']/ul/li[5]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]/h4")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Category']/ul/li[2]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='result_block']/div/a/div[2]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='icon07']/img")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("deleteThis")).click();
		
		

	}

}
