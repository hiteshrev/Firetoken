package upbeatProject;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Food_JournalPage {

	
	private static WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	boolean check=true;

	@Test (priority=1)
	public void Login() throws InterruptedException, AWTException 
	  {	
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();		 	
		    String appUrl = "http://dev.theupbeetkitchen.com/";
		    driver.get(appUrl);
		  	Thread.sleep(2000);
		  	driver.findElement(By.xpath("//*[@id='page_body']/div[5]/div/a[3]")).click();
		  	driver.manage().window().maximize();
            //For shift Join to Login Button
		  	JavascriptExecutor jse = (JavascriptExecutor)driver;
		 	jse.executeScript("$('#signin_div > .shw_div').trigger('click')" );
		  
			driver.findElement(By.id("ID")).sendKeys("shavet@revinfotech.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);		
			driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
}
	@Test (priority=2)
	public void foodjournal() throws InterruptedException, AWTException{
	driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[1]/div/div[1]/i")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("title")).sendKeys("granola cereal");
	Thread.sleep(2000);
	//put path to your image in a clipboard
	WebElement element= driver.findElement(By.xpath("//*[@id='food_form']/div[2]/div[1]/div[2]/div/i"));
	element.click();
	    StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Downloads\\artsfon.com-63613.jpg");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(5000);	
     driver.findElement(By.id("saveData")).click();
 	Thread.sleep(2000);
 	driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[1]/a/i")).click();
	Thread.sleep(2000);
 	driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[1]/a/i")).click();
	Thread.sleep(2000);
 	driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[1]/a/i")).click();
	Thread.sleep(2000);
 	driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[1]/a/i")).click();
    
	}
	@Test (priority=3)
	
	public void AddUpbeetGuru() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		Thread.sleep(2000);
	    driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[2]/div/div[2]/a")).click();
		Thread.sleep(2000);
         driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/input[2]")).clear();
         Thread.sleep(2000);
         driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[1]/div/div/div[3]/div[1]/i")).click();
         Thread.sleep(2000);
         driver.findElement(By.id("upBeetGuru")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[1]/div[2]/div[2]/a/img[2]")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/div[8]/div")).click();
         Thread.sleep(2000);
         driver.findElement(By.id("upgrade_now")).click();
         Thread.sleep(2000);
      
         if(check==true){
        driver.findElement(By.id("payment_type_paypal")).click();
         }
        
  	}
	@Test (priority=4)
    public void Payment() throws InterruptedException  {
			WebElement we = driver.findElement(By.id("login_email"));
		    we.sendKeys("aman-buyer@revinfotech.com");
		    we = driver.findElement(By.id("login_password"));
		    we.sendKeys("india@123");
		    we =driver.findElement(By.name("login.x")); 
		    we.click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@id='modularContent']/table[2]/tbody/tr/td[2]/input")).click();
		    Thread.sleep(7000);
		   	}
		@Test (priority=5)
    public void CancelUpbeetGuru() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
		 Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[1]/div/div[3]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cancelSubscription']/div/div/form/div[2]/textarea")).sendKeys("Thanks for your guidance");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cancelSubscription']/div/div/form/div[3]/button")).click();
		Thread.sleep(3000);
		}
		 @Test (priority=6)
	    public void AddUpbeetguruagain() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		check=false;
		 AddUpbeetGuru();
		 }		 
		 @Test (priority=7)
		    public void Payment2() throws InterruptedException  {
			 driver.findElement(By.id("login_email")).clear();
			 WebElement we = driver.findElement(By.id("login_email"));
					
					  we.clear();
				    we.sendKeys("aman-buyer@revinfotech.com");
				    we = driver.findElement(By.id("login_password"));
				    we.sendKeys("india@123");
				    we =driver.findElement(By.name("login.x")); 
				    we.click();
				    Thread.sleep(5000);
				    driver.findElement(By.xpath("//*[@id='modularContent']/table[2]/tbody/tr/td[2]/input")).click();
				    driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
					 Thread.sleep(15000);
					driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
					 Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='navigation']/ul/li[6]/a")).click();
				   	}
	 @Test (priority=8)
	 
	 public void Payment3() throws InterruptedException, AWTException  {
		 driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		 WebElement element= driver.findElement(By.xpath("//*[@id='addComment']/div/div[5]/i[1]"));
			element.click();
			    StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Downloads\\artsfon.com-63613.jpg");
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			    Robot robot = new Robot();
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);
			    Thread.sleep(5000);
			    driver.findElement(By.id("comment")).sendKeys("Hi!! Jason Methew! from this side");
				 driver.findElement(By.id("comment")).sendKeys(Keys.ENTER);
				 driver.findElement(By.id("customLogout")).click();
				 
				 
		 }
	
		 
			 
	 }
	 


