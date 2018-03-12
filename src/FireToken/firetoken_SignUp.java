package FireToken;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class firetoken_SignUp {
	public WebDriver driver;
	  @Parameters("browser")
	  @BeforeClass
	  public void beforeTest(String browser) throws InterruptedException {
	   if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\geckodriver.exe");
		  driver = new FirefoxDriver();
	  }else if (browser.equalsIgnoreCase("chrome")) { 
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		  driver = new ChromeDriver();
	  } 
	  driver.get("https://dev.firetoken.io/"); 
	  Thread.sleep(2000);
		driver.manage().window().maximize();
			  }
	  @Test public void Signup() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='myNavbar']/a[2]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/div/div/form/div[1]/div/input")).sendKeys("Pushker");
		driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/div/div/form/div[2]/div/input")).sendKeys("Tiwari");
		driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/div/div/form/div[3]/div/input")).sendKeys("testingrevin2@gmail.com");
		driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/div/div/form/div[4]/div/input")).sendKeys("JohnDeff");
		driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/div/div/form/div[5]/div/input")).sendKeys("Pass@123");
		driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/div/div/form/div[6]/div/input")).sendKeys("Pass@123");
		driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/div/div/form/div[7]/div/select/option[14]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/div/div/form/div[9]/label")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/div/div/form/div[10]/button")).click();
		
		Thread.sleep(4000);
		WebElement msg=driver.findElement(By.className("danger"));
		String text=msg.getText();
		System.out.println(text);
		if(driver.findElement(By.className("danger")).isDisplayed())
		{			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='myNavbar']/a[1]")).click();
			Thread.sleep(2000);
			afterTest();
		}
		Assert.assertEquals(text,text);
		}
 	 public void afterTest() {
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/form/div[1]/div/input")).sendKeys("testingrevin2@gmail.com");
			driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/form/div[2]/div/input")).sendKeys("Pass@123");
			driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/form/div[5]/button")).click();;
			System.out.println("User Logged in Successfully");
  } }
		  
		

	