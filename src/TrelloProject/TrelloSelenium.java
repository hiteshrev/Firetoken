package TrelloProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TrelloSelenium {
	public static WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	// Login Trello
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
	public void CreateNewCard() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='board']/div")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("list-name-input")).sendKeys("Create test case in selenium");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='board']/div/form/div/input")).click();
		for (int i = 1; i <= 3; i++) {
			driver.findElement(By.linkText("Add a card…")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='board']/div[1]/div/div[2]/div/div[1]/div/textarea"))
					.sendKeys("New Card Testing " + i);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='board']/div[1]/div/div[2]/div/div[2]/div[1]/input")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='board']/div[1]/div/div[2]/a[" + i + "]/div[3]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[1]/div[7]/div/div[3]/textarea"))
					.sendKeys("Added comment should be reflect with added date time in view report section");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[1]/div[7]/div/div[3]/div/input"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[6]/div[2]/form/div[1]/div/textarea"))
					.sendKeys("Multiple users can use this functionality");
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
	public void AuthenticationAllow() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		Thread.sleep(7000);
	}

	@Test(priority = 4)
	public void GetDateTime() throws InterruptedException {
		String values = driver.findElement(By.id("datetimepicker")).getAttribute("value");
		System.out.println("5. Calender Date & Time" + " : " + values);
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]")).click();
	}

	@Test(priority = 5)
	public void CreateAnotherCard() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='board']/div[2]/form/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='board']/div[2]/form/input")).sendKeys("Create test case in selenium 2");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='board']/div[2]/form/div/input")).click();

		for (int i = 1; i <= 3; i++) {
			driver.findElement(By.xpath("//*[@id='board']/div[2]/div/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/div/div[1]/div/textarea"))
					.sendKeys("Found some new issues " + i);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/div/div[2]/div[1]/input")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/a[" + i + "]/div[3]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[1]/div[7]/div/div[3]/textarea"))
					.sendKeys("Added comment should be reflect with added date time in view report section");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[1]/div[7]/div/div[3]/div/input"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[6]/div[2]/form/div[1]/div/textarea"))
					.sendKeys("Multiple users can use this functionality");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[5]/div[6]/div[2]/form/div[2]/input"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/a")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[1]/div[2]/span/span/span/span[2]")).click();
		AuthenticationAllow();
		Thread.sleep(2000);
		driver.findElement(By.id("datetimepicker")).clear();
		driver.findElement(By.id("datetimepicker")).sendKeys("2017-11-16 17:30");
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(5000);
		GetDateTime();
		Thread.sleep(5000);
		WebElement lstitem = driver.findElement(By.xpath("//*[@id='header']/div[4]/a[4]/span/span[1]"));
		lstitem.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Log Out")).click();
		System.out.println("Log out");

	}

	@Test(priority = 6)
	public void ReLoginDateCheck() throws InterruptedException {
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
		System.out.println("5. Calender Date & Time" + " : " + values);
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
