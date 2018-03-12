package TrelloProject;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Trello_Login {
	public static WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		// EventFiringWebDriver driver = new EventFiringWebDriver(d);
		String appUrl = "https://trello.com/";
		driver.get(appUrl);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		// For shift Join to Login Button
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("user")).sendKeys("myvirtualteams@gmail.com");
		driver.findElement(By.id("password")).sendKeys("myvirtualteams");
		driver.findElement(By.xpath("//*[@id='login']")).submit();
		driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div/div[4]/ul/li[1]/a/span[2]")).click();
		Thread.sleep(10000);
		/*
		 * driver.findElement(By.xpath(
		 * "//*[@id='content']/div/div[1]/div[1]/div[2]/span/span/span/span[1]")
		 * ).click(); Thread.sleep(5000);
		 */
	}

	@Test(priority = 2)
	public void AddNewCard() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Add a card…")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='board']/div[1]/div/div[2]/div/div[1]/div/textarea"))
				.sendKeys("Today added issues");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='board']/div[1]/div/div[2]/div/div[2]/div[1]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Today added issues")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[1]/div[7]/div/div[3]/textarea"))
				.sendKeys("Test New Card");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[1]/div[7]/div/div[3]/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[6]/div[2]/form/div[1]/div/textarea"))
				.sendKeys("Please complete these tasks on given time");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[6]/div[2]/form/div[2]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/a")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[1]/div[2]/span/span/span/span[1]")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public void Authi() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.className("plugin-iframe")));
		driver.findElement(By.xpath("//*[@id='btnAuth']")).click();
		Thread.sleep(5000);
		Set<String> allHandles = driver.getWindowHandles();
		// count the handles Here count is=2
		System.out.println("Done");
		// Get current handle or default handle
		String currentWindowHandle = allHandles.iterator().next();
		System.out.println("Done");
		// Remove first/default Handle
		allHandles.remove(allHandles.iterator().next());
		// get the last Window Handle
		String lastHandle = allHandles.iterator().next();
		System.out.println("last window handle" + lastHandle);
		// switch to second/last window, because we know there are only two
		// windows 1-parent window 2-other window(ad window)
		driver.switchTo().window(lastHandle);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id='surface']/div[2]/div[4]/form/input[1]")).click();
		Thread.sleep(5000);
		driver.switchTo().window(currentWindowHandle);
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[9]/iframe")));
		driver.findElement(By.id("datetimepicker")).clear();
		driver.findElement(By.id("datetimepicker")).sendKeys("2017-11-13 11:00");
		Thread.sleep(5000);
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(10000);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("html/body/div[1]")).click();
		Thread.sleep(5000);
		Actions builder = new Actions(driver);

		Action dragAndDrop = builder
				.clickAndHold(driver.findElement(By.xpath("//*[@id='board']/div[1]/div/div[2]/a[6]/div[3]")))
				.moveToElement(driver.findElement(By.xpath("//*[@id='board']/div[3]/div/a")))
				.release(driver.findElement(By.xpath("//*[@id='board']/div[3]/div/a"))).build();
		dragAndDrop.perform();

		driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[1]/div[2]/span/span/span/span[1]")).click();
		Thread.sleep(10000);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"
		FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.className("plugin-iframe")));
		driver.findElement(By.xpath("/html/body/div[1]")).click();
		Thread.sleep(3000);
		WebElement lstitem1 = driver.findElement(By.xpath("//*[@id='header']/div[4]/a[4]/span/span[1]"));
		lstitem1.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Log Out")).click();
		System.out.println("Log out");
		driver.close();
	}
}
