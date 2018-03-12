package CaptureScreenshots;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
public class FacebookScreenshots {	
	
	@Test
public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
				EventFiringWebDriver driver = new EventFiringWebDriver(d);
		String appUrl = "https://www.facebook.com/";
		driver.get(appUrl);
		Thread.sleep(2000);
		driver.findElement(By.id("email")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("revinfotech1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("dilansha@revinfotech");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id='u_0_a']")).submit();
		driver.findElement(By.xpath("//*[@id='u_0_2']")).submit();
		Thread.sleep(5000);
		driver.navigate().to("https://www.facebook.com/Lio.Yoshida?lst=100001153278922%3A100001082088287%3A1518581384");
		Thread.sleep(5000);
		//System.setProperty("webdriver.chrome.driver","./Resource/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver1 = new ChromeDriver(options);
		driver1.get("https://drupal-stage-web.weather.com");
				
	}
}