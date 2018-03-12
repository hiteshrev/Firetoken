package upbeatProject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BuyPaidCourse {
	private static WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();
		String appUrl = "https://dev.theupbeetkitchen.com/";
		driver.get(appUrl);
		Thread.sleep(2000);
		driver.findElement(By.id("close_tour")).click();
		driver.manage().window().maximize();
		// For shift Join to Login Button
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("$('#signin_div > .shw_div').trigger('click')");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("ID")).sendKeys("testingrevin@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("loginButton")).submit();
		Thread.sleep(2000);
		
	}

	@Test(priority = 2)
	public void Payment() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.linkText("Learn"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Courses")).click();
		driver.findElement(By.id("srch")).sendKeys("CANADIAN LIVING COOKING CLASS");
		 driver.findElement(By.id("connect-search-btn")).click();
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div/a/div[2]/img")).isDisplayed()){
			driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div/a/div[2]/img")).click();
		}
			
		driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/div/div[3]/div[2]/form/input[7]")).click();
		Thread.sleep(2000);
		//driver.navigate().to("https://www.sandbox.paypal.com/webapps/hermes?token=88A14835302210200&useraction=commit&mfid=1491999149134_17cf78d29d510#/checkout/login");
	if (driver.findElement(By.id("loadLogin")).isDisplayed()){
		driver.findElement(By.xpath("//*[@id='loadLogin']")).click();
		 driver.findElement(By.id("login_email")).clear();
		 WebElement we = driver.findElement(By.id("login_email"));
				  we.clear();
			    we.sendKeys("aman-buyer@revinfotech.com");
			    we = driver.findElement(By.id("login_password"));
			    we.sendKeys("india@123");
			    we =driver.findElement(By.name("login.x")); 
			    we.click();
			    Thread.sleep(5000);
			    if (driver.findElement(By.id("continue")).isDisplayed())
				{
					driver.findElement(By.id("continue")).click();
				}
			    Thread.sleep(5000);
			    driver.findElement(By.id("customLogout")).click();
	}
	else{
		
		driver.switchTo().frame("injectedUl");
		WebElement we = driver.findElement(By.xpath(".//*[@id='email']"));
		we.sendKeys("aman-buyer@revinfotech.com");
		we = driver.findElement(By.xpath(".//*[@id='password']"));
		we.sendKeys("india@123");
		we = driver.findElement(By.xpath(".//*[@id='btnLogin']"));
		we.click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id='confirmButtonTop']")).click();
		Thread.sleep(3000);
		/* jse.executeScript("alert('Users Logout Successfully')" ); */
		driver.findElement(By.id("customLogout")).click();
		Thread.sleep(2000);
		driver.close();
	}
	}
}
