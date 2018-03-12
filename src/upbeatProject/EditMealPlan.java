package upbeatProject;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EditMealPlan {

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
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div[5]/a/div[2]/img")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/div/div[3]/div/div[1]/a[1]/img")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/ul/li[4]/div/div/span[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/ul/li[3]/input")).clear();
			driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/ul/li[3]/input")).sendKeys("15");
			Thread.sleep(2000);
			driver.findElement(By.id("title")).clear();
			driver.findElement(By.id("title")).sendKeys("Day Healthy Meal Plan - Cooking Light");
			Thread.sleep(2000);
			
			// Delete Image and Upload New Image
			jse.executeScript("deleteMainPhoto();");
			WebElement uploading=driver.findElement(By.xpath("//*[@id='editCourseMainPhoto']/a/img"));
		    uploading.click();		    	   
			driver.findElement(By.xpath("//*[@id='editCourseMainPhoto']/a/img"));
			
			//Copy your file's absolute path to the clipboard
			StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Pictures\\30-day-weight-loss-exercise-plan..jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			
			//Paste the file's absolute path into the File name field of the File Upload dialog box
			//native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			//Add youtube video...
			jse.executeScript("deleteMainVideo();");
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div[1]/select/option[2]")).click();
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
			Thread.sleep(5000);
			WebElement Youtube=driver.findElement(By.id("video_id"));
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
			Thread.sleep(5000);
			Youtube.clear();
			Youtube.sendKeys("JLfyG6-4SfU");
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div[1]/div/span/button")).click();
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div[2]/select/option[2]")).click();
			//Add Description
			Thread.sleep(2000);			
			jse.executeScript("	tinyMCE.activeEditor.setContent('All of our meal plans include recipes, a shopping list, and a cooking plan.')" );
			// Add Recipes or Delete Existing Recipe
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[1]/div[2]/div/div/span[1]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[1]/div[2]/div/div/span/input[2]")).sendKeys(" Tomatillo Salsa Tacos with Baked Plantains");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[1]/div[2]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
	        driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[1]/div[2]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
	        Thread.sleep(2000); 
	        
	        //Add Recipe 2
	        jse.executeScript("addAnotherSkill()");
	        driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[2]/div[2]/div/div/span/input[2]")).sendKeys("Ancient Grain Pasta");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[2]/div[2]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
	        driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[2]/div[2]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
	        Thread.sleep(2000); 
	        
	        //Update edit details
	        jse.executeScript("updateMeal(5);");
	        driver.findElement(By.id("customLogout")).click();
			Thread.sleep(2000);
			driver.close();
	        
			} 								
				 	
			
	}}
