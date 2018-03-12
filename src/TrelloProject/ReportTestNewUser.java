package TrelloProject;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ReportTestNewUser {
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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div/div[4]/ul/li[3]/a/span[2]")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void InviteNewUser() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/a[4]/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[2]/div/div/div[2]/div/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[5]/div/div[2]/div/div/div/div[1]/input")).sendKeys("testingrevin@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[5]/div/div[2]/div/div/div/div[1]/input")).sendKeys(Keys.ENTER);
		WebElement lstitem = driver.findElement(By.xpath("//*[@id='header']/div[4]/a[4]/span/span[1]"));
		lstitem.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Log Out")).click();
		driver.close();
	}

	@Test(priority = 1)
	public void LoginWithInvitedUser() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("user")).sendKeys("testingrevin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("password@123");
		driver.findElement(By.xpath("//*[@id='login']")).submit();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div/div[1]/ul/li[1]/a/span[2]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void CreateNewCardList() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='board']/div[3]/form/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='board']/div[3]/form/input")).sendKeys("Resolved Issues List");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='board']/div[3]/form/div/input")).click();
		Thread.sleep(3000);
		for (int i = 1; i <= 3; i++) {
			driver.findElement(By.xpath("//*[@id='board']/div[3]/div/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='board']/div[3]/div/div[2]/div/div[1]/div/textarea"))
					.sendKeys("Test Step " + i);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='board']/div[3]/div/div[2]/div/div[2]/div[1]/input")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='board']/div[3]/div/div[2]/a[" + i + "]/div[3]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[1]/div[7]/div/div[3]/textarea"))
					.sendKeys("All old and new functionality has been completed");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[1]/div[7]/div/div[3]/div/input"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[6]/div[2]/form/div[1]/div/textarea"))
					.sendKeys("Resolved");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[6]/div[2]/form/div[2]/input"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/a")).click();

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[1]/div[2]/span/span/span/span[2]")).click();
	}

	@Test(priority = 3)
	public void NewUserAuthentication() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.className("plugin-iframe")));
		driver.findElement(By.xpath("//*[@id='btnAuth']")).click();
		Thread.sleep(5000);
		Set<String> allHandles = driver.getWindowHandles();
		// count the handles Here count is=2
		System.out.println("1. Newly added user able to view the one time authentication pop up");
		// Get current handle or default handle
		String currentWindowHandle = allHandles.iterator().next();
		System.out.println("2. User is able for allow the authentication");
		// Remove first/default Handle
		allHandles.remove(allHandles.iterator().next());
		// get the last Window Handle
		String lastHandle = allHandles.iterator().next();
		System.out.println("3. Records are showing as per the selected date");
		// switch to second/last window, because we know there are only two
		// windows 1-parent window 2-other window(ad window)
		driver.switchTo().window(lastHandle);
		System.out.println("4. Newly added user able for view the report");
		driver.findElement(By.xpath("//*[@id='surface']/div[2]/div[4]/form/input[1]")).click();
		Thread.sleep(5000);
		driver.switchTo().window(currentWindowHandle);
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[9]/iframe")));
		Thread.sleep(5000);
		driver.findElement(By.id("datetimepicker")).clear();
		driver.findElement(By.id("datetimepicker")).sendKeys("2017-03-14 05:30");
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(7000);
		String values1 = driver.findElement(By.id("datetimepicker")).getText();
		System.out.println("5. Calender Date & Time" + " : " + values1);
		Thread.sleep(5000);
		driver.findElement(By.id("datetimepicker")).clear();
		driver.findElement(By.id("datetimepicker")).sendKeys("2017-11-18 05:30");
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(5000);
		String myText = driver.findElement(By.xpath("//*[@id='divContent']/div[2]/div/div")).getText();
		System.out.println("Total Log Count :  " + myText);
		Thread.sleep(5000);
		driver.findElement(By.id("datetimepicker")).clear();
		driver.findElement(By.id("datetimepicker")).sendKeys("2017-11-17 11:25");
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(10000);
		String values3 = driver.findElement(By.id("datetimepicker")).getAttribute("value");
		System.out.println("7. Calender Date & Time" + " : " + values3);
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[1]")).click();
		Thread.sleep(5000);
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder
				.clickAndHold(driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/a[3]/div[3]")))
				.moveToElement(driver.findElement(By.xpath("//*[@id='board']/div[3]/div/a")))
				.release(driver.findElement(By.xpath("//*[@id='board']/div[3]/div/a"))).build();
		dragAndDrop.perform();
		driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[1]/div[2]/span/span/span/span[1]")).click();
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.className("plugin-iframe")));
		Thread.sleep(3000);
		String values2 = driver.findElement(By.id("datetimepicker")).getAttribute("value");
		System.out.println("8. Calender Date & Time" + " : " + values2);
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]")).click();
		Thread.sleep(5000);
		WebElement lstitem = driver.findElement(By.xpath("//*[@id='header']/div[4]/a[4]/span/span[1]"));
		lstitem.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Log Out")).click();
	}

	@Test(priority = 4)
	public void ReLoginToCheckDate() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("user")).sendKeys("myvirtualteams@gmail.com");
		driver.findElement(By.id("password")).sendKeys("myvirtualteams");
		driver.findElement(By.xpath("//*[@id='login']")).submit();
		driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div/div[4]/ul/li[3]/a/span[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[1]/div[2]/span/span/span/span[2]")).click();
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.className("plugin-iframe")));
		Thread.sleep(5000);
		String values = driver.findElement(By.id("datetimepicker")).getAttribute("value");
		System.out.println("9. Calender Date & Time" + " : " + values);
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]")).click();
		Thread.sleep(5000);
		WebElement lstitem = driver.findElement(By.xpath("//*[@id='header']/div[4]/a[4]/span/span[1]"));
		lstitem.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Log Out")).click();
		driver.close();
	}

	
}
