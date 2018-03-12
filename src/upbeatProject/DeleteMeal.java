package upbeatProject;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteMeal {
	private static WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	@Test (priority=1)
	public static void main(String[] args) throws InterruptedException, AWTException {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();{
	    	String appUrl = "http://dev.theupbeetkitchen.com/";
		    driver.get(appUrl);
		    Thread.sleep(2000);
		  	driver.findElement(By.linkText("X")).click();
		  	driver.manage().window().maximize();
            JavascriptExecutor jse = (JavascriptExecutor)driver;
		 	jse.executeScript("$('#signin_div > .shw_div').trigger('click')" );
		  	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			driver.findElement(By.id("ID")).sendKeys("admin");
			driver.findElement(By.id("Password")).sendKeys("UpBeet@5075");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[1]/div[1]/nav/div/div[2]/div/ul/li[5]/a")).click();				
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='result_block']/div[2]/a/div[2]/img")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='Main-1']/div/div[1]/a[2]/img")).click();
			Thread.sleep(2000);
		  	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		 	System.out.println("Meal Deleted Successfully...");
		 	} 								
				 	
			
	}}