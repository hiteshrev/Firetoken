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

public class EditRecipe {
	private static WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
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
	@Test (priority=2)
	public void EditDetailsRecipe() throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
	// driver.navigate().to("https://dev.theupbeetkitchen.com/m/recipes/edit/688");
		if (driver.findElement(By.linkText("Recipes")).isDisplayed())
		{
			driver.findElement(By.linkText("Recipes")).click();
	    }
		driver.findElement(By.xpath("//*[@id='Eats_Anything_selectedfilter']/span")).click();
		driver.findElement(By.id("search_text")).sendKeys("Classic American grilled burger");
		driver.findElement(By.id("connect-search-btn")).click();
		driver.findElement(By.xpath("//*[@id='page_block_1261']/div/div[2]/div[4]/div/a/div[2]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tars-widget-fab")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Main-1']/div[1]/a[8]/img")).click();
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/ul/li[2]/div/div/span[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ad_in_plus']/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("quantity")).sendKeys("10");
		driver.findElement(By.xpath("//*[@id='unit']/option[29]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ingredient")).click();
		driver.findElement(By.id("new_ingre")).sendKeys("ch");
		Thread.sleep(2000);
		 driver.findElement(By.id("new_ingre")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("new_ingre")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("note")).sendKeys("Spray a non-stick frying pan with oil and heat over medium-high heat.");
		Thread.sleep(2000);
	   driver.findElement(By.xpath("//*[@id='ingre_place']/div/div[2]/div[2]/div[5]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add Heading")).click();
		driver.findElement(By.id("cust-heading-new")).sendKeys("Cheese Burger");
		driver.findElement(By.xpath("//*[@id='ingre_place']/div/div[3]/div[2]/div[2]/button")).click();
		Thread.sleep(2000);
		//Add Step 1
		driver.findElement(By.xpath("//*[@id='a2392']/div[1]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='show_div2392']/div[3]/div/input")).sendKeys("Spray a non-stick");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='show_div2392']/div[5]/div/a/span[1]")).click();
		Thread.sleep(10000);
		if (driver.findElement(By.xpath("//*[@id='34405']/label/input")).isDisplayed()){
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='34405']/label/input")).click();
			Thread.sleep(5000);
		}
		Thread.sleep(5000);
		//Add Equipments in Step 1
		driver.findElement(By.xpath("//*[@id='show_div2392']/div[7]/div/div/span/input[2]")).sendKeys("p");
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='show_div2392']/div[7]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='show_div2392']/div[7]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		
		//Add Skills
		driver.findElement(By.xpath("//*[@id='show_div2392']/div[9]/div/div/span/input[2]")).sendKeys("p");
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='show_div2392']/div[9]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		 driver.findElement(By.xpath("//*[@id='show_div2392']/div[9]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		 Thread.sleep(4000);
		// Add Recipe Step 1 Description
			WebElement body = driver.findElement(By.id("2392-instruction-description_ifr"));
			body.sendKeys("  Spray a non-stick frying pan with oil and heat over medium-high heat. Cook patties, turning, for 10-15 minutes or until cooked through. Top with cheese and cook for 1 minute or until the cheese just melts.");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			
			// Add image in step 1
			driver.findElement(By.xpath("//*[@id='2392']/span")).click(); 
			Thread.sleep(15000);
			WebElement Photoupload= driver.findElement(By.xpath("//*[@id='imageloadbutton']/div[1]"));
			Photoupload.click();
			Thread.sleep(4000);
			    StringSelection ss1 = new StringSelection("C:\\Users\\Dell-1\\Downloads\\Bestie.jpg");
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
			    Robot robot2 = new Robot();
			    robot2.keyPress(KeyEvent.VK_ENTER);
			    robot2.keyRelease(KeyEvent.VK_ENTER);
			    robot2.keyPress(KeyEvent.VK_CONTROL);
			    robot2.keyPress(KeyEvent.VK_V);
			    robot2.keyRelease(KeyEvent.VK_V);
			    robot2.keyRelease(KeyEvent.VK_CONTROL);
			    robot2.keyPress(KeyEvent.VK_ENTER);
			    robot2.keyRelease(KeyEvent.VK_ENTER);
			    robot2.keyRelease(KeyEvent.VK_ENTER);
		    Thread.sleep(10000);
		    // Add Video in step 1
		    driver.findElement(By.xpath("//*[@id='show_div2392']/div[11]/div/a[2]/span")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.id("yout_id")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.id("video_data")).sendKeys("PArFmFwkvcI");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@id='vid2392']/div/form/span")).click();
		    Thread.sleep(3000);
		    WebElement body1 = driver.findElement(By.id("mce_0_ifr"));
			body1.sendKeys("  Meanwhile, for onion rings, combine the flour, polenta, chilli powder and salt in a large bowl. Season with freshly ground black pepper. Make a well in centre. Add buttermilk and whisk until well combined.");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			 WebElement body2 = driver.findElement(By.id("mce_1_ifr"));
				body2.sendKeys(" Add enough oil to a saucepan to come halfway up side. Heat over medium-high heat until oil reaches 180C on a cook’s thermometer. Dip one-third of the onion rings, 1 at a time, into the buttermilk batter to evenly coat, then add to the hot oil. Deep-fry for 2-3 minutes or until crisp and golden. Drain on a plate lined with paper towel. Repeat with remaining onion rings and buttermilk batter.");
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
			if (driver.findElement(By.linkText("Save")).isDisplayed()){
				driver.findElement(By.linkText("Save")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("tars-widget-fab")).click();
				Thread.sleep(3000);
				
				}

}}
