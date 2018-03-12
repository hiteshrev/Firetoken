package upbeatProject;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BuyPaidMealPlan {
	private static WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;

	@Test (priority=1)
	public void Login() throws InterruptedException 
	  {	
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();		 	
		    String appUrl = "http://dev.theupbeetkitchen.com/";
		    driver.get(appUrl);
		  	Thread.sleep(2000);
		  	driver.findElement(By.linkText("X")).click();
		  	driver.manage().window().maximize();
            //For shift Join to Login Button
		  	JavascriptExecutor jse = (JavascriptExecutor)driver;
		 	jse.executeScript("$('#signin_div > .shw_div').trigger('click')" );
		  	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			driver.findElement(By.id("ID")).sendKeys("sumit1@revinfotech.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[1]/div[1]/nav/div/div[2]/div/ul/li[5]/a")).click();				
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='result_block']/div[3]/a/div[2]/img")).click();
			Thread.sleep(2000);
			//Give Review to the Meal
			new Actions(driver);
    	    ((JavascriptExecutor)driver).executeScript("scroll(0,20000)");
			Thread.sleep(3000L);
			((JavascriptExecutor)driver).executeScript("scroll(0,20000)");
			Thread.sleep(3000L);
			driver.findElement(By.xpath("//*[@id='write_review']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='review_form']/div/span[4]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='review_message']")).sendKeys("“I also get to eat a variety of vegetables I normally would not buy although I do agree that they tend to rely heavily on the spaghetti squash.” ");
			Thread.sleep(1000);
			driver.findElement(By.id("send_review")).click();
			Thread.sleep(1000);
			((JavascriptExecutor)driver).executeScript("scroll(0,20000)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='MainContent']/a/div")).click();
			Thread.sleep(2000);
			//Recipes Add to shopping list
			jse.executeScript("$('.recipe_344').val('5')" );
			Thread.sleep(1000);
			jse.executeScript("$('.recipe_345').val('6')" );
			Thread.sleep(1000);
			jse.executeScript("$('.recipe_346').val('7')" );
			Thread.sleep(1000);
			jse.executeScript("$('.recipe_345').val('9')" );
			Thread.sleep(1000);
			jse.executeScript("$('.recipe_538').val('10')" );
			Thread.sleep(1000);
			jse.executeScript("$('.recipe_346').val('4')" );
			Thread.sleep(1000);
			jse.executeScript("$('.recipe_388').val('8')" );
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='myModal']/div/div/form/div[3]/button[2]")).click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
		 	alert.accept();
		 	Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='navigation']/ul/li[7]/a")).click();
			Thread.sleep(1000);
			//Clear Shopping List After View
			((JavascriptExecutor)driver).executeScript("scroll(0,20000)");
			driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[1]/div[1]/a/span")).click();
			Thread.sleep(1000);			
		 	alert.accept();
			driver.findElement(By.xpath("//*[@id='navigation']/ul/li[5]/a")).click();	
			Thread.sleep(1000);
			//Search Meal
			driver.findElement(By.xpath("//*[@id='sort']/option[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='srch']")).sendKeys("The Lean Machine Diet");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='connect-search-btn']/i")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='result_block']/div/a/div[2]/img")).click();
		
			//Buy Meal Plan Using Search Functionality
			
			driver.findElement(By.xpath("//*[@id='MainContent']/div[4]/div[2]/form/input[8]")).click();
			Thread.sleep(2000);
			driver.navigate().to("https://www.sandbox.paypal.com/webapps/hermes?token=2RV200104J768144A&useraction=commit&mfid=1493034210371_4b0dd069d63c0#/checkout/login");
			driver.navigate().to("https://www.sandbox.paypal.com/webapps/hermes?token=2RV200104J768144A&useraction=commit&mfid=1493034210371_4b0dd069d63c0#/checkout/login");
	}
		@Test (priority=2)
	    public void Payment() throws InterruptedException  {
				driver.switchTo().frame("injectedUl");
			    WebElement we = driver.findElement(By.id("email"));
			    we.sendKeys("aman-buyer@revinfotech.com");
			    we = driver.findElement(By.id("password"));
			    we.sendKeys("india@123");
			    we =driver.findElement(By.xpath("//*[@id='btnLogin']")); 
			    we.click();
			    Thread.sleep(15000);
			    driver.findElement(By.xpath("//*[@id='confirmButtonTop']")).click();
			    Thread.sleep(3000);	
			    System.out.println("Meal purchased successfully");
			    driver.findElement(By.id("customLogout")).click();
				Thread.sleep(2000);
				
	}
				
	}
