package upbeatProject;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class SignUpByFacebook {
	private static WebDriver driver;
	static JavascriptExecutor jse = (JavascriptExecutor)driver;
	@Test(priority=1)
  public void SignupByFacebook() throws InterruptedException 
  {	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\chromedriver.exe");
		driver = new ChromeDriver();		 	
		String appUrl = "http://live.theupbeetkitchen.com/";
		driver.get(appUrl);
			Thread.sleep(2000);
			driver.findElement(By.id("close_tour")).click();
			driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Thread.sleep(2000);
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String newSet = driver.getWindowHandle();
		driver.switchTo().window(newSet); 	 
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("pushker@revinfotech.com");
		driver.findElement(By.id("pass")).sendKeys("pushker123");
		driver.findElement(By.id("loginbutton")).submit();
		Thread.sleep(2000);
		/*driver.findElement(By.xpath("//*[@id='facebook']/body")).click();
		Thread.sleep(2000);*/
		//driver.findElement(By.xpath("html/body/div[5]/div[2]/div/div/form/div/div[1]/div[2]/div[1]/div[1]/button")).click();
		driver.findElement(By.id("customLogout")).click();
	
  }
	@Test(priority=2)
	public void loginwithfacebook() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		 driver.findElement(By.id("customLogin")).click();
		 driver.findElement(By.xpath("//*[@id='ands_login_ajax_wrap']/div/div[3]/div/a/span")).click();
		 driver.findElement(By.id("customLogout")).click();
		 driver.close();
		}}
