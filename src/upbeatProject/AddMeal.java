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

public class AddMeal {
	private static WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;

	@Test (priority=1)
	public static void main(String[] args) throws InterruptedException, AWTException {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();{
				String appUrl = "https://dev.theupbeetkitchen.com/New_Dolphin/Dolphin-v.7.3.3.1";
				driver.get(appUrl);
				Thread.sleep(2000);
				driver.findElement(By.id("close_tour")).click();
				driver.manage().window().maximize();
				// For shift Join to Login Button
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("$('#signin_div > .shw_div').trigger('click')");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			driver.findElement(By.id("ID")).sendKeys("HappyCustomers@theupbeetkitchen.com");
			driver.findElement(By.id("Password")).sendKeys("vhKP.xrj");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[1]/div[1]/nav/div/div[2]/div/ul/li[5]/a")).click();				
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/form/div[2]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("title")).sendKeys("Test Meal Plan");
			Thread.sleep(2000);
			WebElement uploading=driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/a/img"));
		    uploading.click();		    	   
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/a/img"));
			//Copy your file's absolute path to the clipboard
			StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Pictures\\2799d0a060.jpg");
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
			//Add youtube video...
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div[1]/select/option[2]")).click();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
			Thread.sleep(2000);
			WebElement Youtube=driver.findElement(By.id("video_id"));
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
			Thread.sleep(5000);
			Youtube.sendKeys("CgjfzLMmGV0");
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div[1]/div/span/button")).click();
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div[2]/select/option[2]")).click();
			//Add Description
			Thread.sleep(2000);			
			jse.executeScript("	tinyMCE.activeEditor.setContent('<h1>Native API text</h1> TinyMCE')" );
			// Add Recipes
			driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[2]/div/div/span/input[2]")).sendKeys("Almond Butter");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[2]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
	        driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[7]/div[2]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
	        jse.executeScript("addMealDB();" );
	        driver.findElement(By.id("customLogout")).click();
			Thread.sleep(2000);
			driver.close();
			} 								
				 		
	}}