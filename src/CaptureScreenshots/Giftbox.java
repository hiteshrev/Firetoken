package CaptureScreenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

@Test(priority=1)
public class Giftbox {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(d);
		String appUrl = "https://giftbox2.myshopify.com/";
		driver.get(appUrl);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("9595@dssd.com");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='myModal-gift']/div/div/div/div/div/div/div[2]/div/div[3]/div[3]/button")).click();
		Thread.sleep(10000);		
		driver.findElement(By.xpath("//*[@id='box-container']/div/section[5]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='myModal-gift']/div/div/div/div/div/div/div[2]/div/div[4]/div[3]/button")).click();
		driver.close();
	}
}
