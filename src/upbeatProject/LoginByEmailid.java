package upbeatProject;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginByEmailid {
	//private static WebDriver driver;
		@Test (priority=1)
	  public void Login() throws InterruptedException 
	  {	
		    System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();		 	
		    String appUrl = "http://dev.theupbeetkitchen.com/";
		    driver.get(appUrl);
		  	Thread.sleep(2000);
		  	driver.findElement(By.linkText("X")).click();
		  	driver.manage().window().maximize();
              
		   //For shift Join to Login Button
		  	JavascriptExecutor jse = (JavascriptExecutor)driver;
		 	jse.executeScript("$('#signin_div > .shw_div').trigger('click')" );
		  	
		 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			driver.findElement(By.id("ID")).sendKeys("hiteshbali52.hb@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			String PageTitle = driver.getTitle();
			System.out.println("Verified Business User: - "+PageTitle);
			//Assert.assertTrue(PageTitle.equalsIgnoreCase("My Account"), "Page title doesn't match");
			driver.findElement(By.id("customLogout")).click();
			Thread.sleep(2000);
			  
			    driver.findElement(By.id("customLogin")).click();
				driver.findElement(By.name("ID")).sendKeys("admin");
				driver.findElement(By.id("Password")).sendKeys("UpBeet@5075");
				driver.findElement(By.id("loginButton")).submit();
				driver.getTitle();
				System.out.println("Admin: - "+PageTitle);
				//Assert.assertTrue(PageTitle1.equalsIgnoreCase("My"), "Page title doesn't match");
				driver.findElement(By.id("customLogout")).click();
				Thread.sleep(2000);
				
				jse.executeScript("alert('Users Logout Successfully')" );
				//((JavascriptExecutor)driver).executeScript("Users Logout Successfully();");
				Thread.sleep(3000);
				 driver.close();
	  }
		
		
	}
