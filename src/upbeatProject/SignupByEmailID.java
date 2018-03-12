package upbeatProject;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
public class SignupByEmailID {
	private static WebDriver driver;
	static JavascriptExecutor jse = (JavascriptExecutor)driver;
		public static void main(String[] args) throws InterruptedException {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
			 driver = new ChromeDriver();
			 String appUrl = "http://dev.theupbeetkitchen.com";
			 driver.get(appUrl);
				driver.findElement(By.linkText("X")).click();
				//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				Thread.sleep(2000);
//			  	driver.manage().window().maximize();
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    String newSet = driver.getWindowHandle();
				driver.switchTo().window(newSet); 	
				driver.manage().window().maximize();
			       //For shift Join to Login Button
			 	JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("$('#signin_div > .shw_div').trigger('click')" );
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				driver.findElement(By.id("ID")).sendKeys("HappyCustomers@theupbeetkitchen.com");
				driver.findElement(By.id("Password")).sendKeys("UpBeet@5075");
				driver.findElement(By.id("loginButton")).submit();
				Thread.sleep(2000);	
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			  	String strPageTitle = driver.getTitle();
				System.out.println("Page title: - "+strPageTitle);
				Assert.assertTrue(strPageTitle.equalsIgnoreCase("The UpBeet Kitchen"), "Page title doesn't match");
				Thread.sleep(2000);		
				driver.findElement(By.xpath("//*[@id='ands_login_ajax_wrap']/div/div[2]/div[2]/div/button")).click();
	  }
		
		
		// Already Registered Users
		
		  public void SignupEmailid() throws InterruptedException {	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   String newSet = driver.getWindowHandle();
				driver.switchTo().window(newSet);			
				driver.findElement(By.name("Email[0]")).sendKeys("test.myvirtualteams@gmail.com");
				driver.findElement(By.name("Password[0]")).sendKeys("123456");
				driver.findElement(By.name("Password_confirm[0]")).sendKeys("123456");
				driver.findElement(By.id("join_form_input_TermsOfUse")).click();
				driver.findElement(By.name("do_submit")).submit();
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
			  	String strPageTitle = driver.getTitle();
				System.out.println("Page title: - "+strPageTitle);
				Assert.assertTrue(strPageTitle.equalsIgnoreCase("http://dev.theupbeetkitchen.com/"), "Page title doesn't match");
				Thread.sleep(5000);
		  }
		
		@Test (priority=3)
		//Confirmation password is wrong
		  public void SignupByEmailId() throws InterruptedException
		  {	
			  	driver.manage().window().maximize();
				driver.findElement(By.linkText("X")).click();
				//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				Thread.sleep(2000);
			  	driver.findElement(By.id("customJoin")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    String newSet = driver.getWindowHandle();
				driver.switchTo().window(newSet); 
				driver.findElement(By.xpath("//*[@id='ands_login_ajax_wrap']/div/div[2]/div[2]/div/button")).click();
				driver.findElement(By.name("Email[0]")).sendKeys("test.myvirtualteams@gmail.com");
				driver.findElement(By.name("Password[0]")).sendKeys("123456");
				driver.findElement(By.name("Password_confirm[0]")).sendKeys("12345678");
				driver.findElement(By.id("join_form_input_TermsOfUse")).click();
				driver.findElement(By.name("do_submit")).submit();
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			  	String strPageTitle = driver.getTitle();
				System.out.println("Page title: - "+strPageTitle);
				Assert.assertTrue(strPageTitle.equalsIgnoreCase("http://dev.theupbeetkitchen.com/"), "Page title doesn't match");
				Thread.sleep(2000);	
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
						  
		  }
		@Test (priority=4)
		//without fill any thing and click submit button
		  public void SignupByemailId() throws InterruptedException
		  {	
			  
			  	driver.manage().window().maximize();
			  	driver.findElement(By.id("customJoin")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    String newSet = driver.getWindowHandle();
				driver.switchTo().window(newSet); 	 
				driver.findElement(By.xpath("//*[@id='ands_login_ajax_wrap']/div/div[2]/div[2]/div/button")).click();
				driver.findElement(By.id("join_form_input_TermsOfUse")).click();
				driver.findElement(By.name("do_submit")).submit();
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			  	String strPageTitle = driver.getTitle();
				System.out.println("Page title: - "+strPageTitle);
				Assert.assertTrue(strPageTitle.equalsIgnoreCase("http://dev.theupbeetkitchen.com/"), "Page title doesn't match");
				Thread.sleep(2000);	
						  
		  }
		  @AfterClass 
	      public static void Close() 
		  {

			  driver.close();

	      }
	}
