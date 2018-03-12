package TrelloProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Trello_ReportTest {
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
		driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[1]/div[2]/span/span/span/span[1]")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void Authi() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.className("plugin-iframe")));
		driver.findElement(By.xpath("//*[@id='btnAuth']")).click();
		Thread.sleep(5000);
		Set<String> allHandles = driver.getWindowHandles();
		// count the handles Here count is=2
		System.out.println("Count of windows:" + allHandles.size());
		// Get current handle or default handle
		String currentWindowHandle = allHandles.iterator().next();
		System.out.println("currentWindow Handle" + currentWindowHandle);
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
		driver.findElement(By.id("datetimepicker")).sendKeys("2017-22-10 10:30");
		Thread.sleep(5000);
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(10000);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[1]")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public void CheckDefaultDate() throws InterruptedException {
		WebElement lstitem = driver.findElement(By.xpath("//*[@id='header']/div[4]/a[4]/span/span[1]"));
		lstitem.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Log Out")).click();
		System.out.println("Log out");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("user")).sendKeys("myvirtualteams@gmail.com");
		driver.findElement(By.id("password")).sendKeys("myvirtualteams");
		driver.findElement(By.xpath("//*[@id='login']")).submit();
		driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div/div[4]/ul/li[1]/a/span[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[1]/div[2]/span/span/span")).click();
		Thread.sleep(2000);
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
