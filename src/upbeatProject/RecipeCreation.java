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

public class RecipeCreation {private static WebDriver driver;
JavascriptExecutor jse = (JavascriptExecutor) driver;

@Test(priority = 1)
public void Login() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
	driver = new ChromeDriver();
	String appUrl = "https://dev.theupbeetkitchen.com/";
	driver.get(appUrl);
	
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
private void CreateRecipe() throws InterruptedException, AWTException{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	if (driver.findElement(By.linkText("Recipes")).isDisplayed())
	{
		driver.findElement(By.linkText("Recipes")).click();
		/*Thread.sleep(2000);
		driver.findElement(By.id("tars-widget-fab")).click();
		Thread.sleep(2000);*/
		driver.findElement(By.linkText("Add New Recipe")).click();
		driver.findElement(By.xpath("//*[@id='addRecipe']/div/div/div[2]/input")).sendKeys("Classic American grilled burger");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='addRecipe']/div/div/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/ul/li[2]/div/div/span[1]")).click();
		WebElement uploading = driver.findElement(By.xpath("//*[@id='editRecipeMainPhoto']/a/img"));
		uploading.click();
		driver.findElement(By.xpath("//*[@id='editRecipeMainPhoto']/a/img"));
		Thread.sleep(3000);
		StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Downloads\\classic_american_grilled-cheeseburger_1980x1320-121130-1.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		//Add youtube video...
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[5]/div[1]/select/option[2]")).click();
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
				Thread.sleep(2000);
				WebElement Youtube=driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[5]/div[1]/div/input[1]"));
				driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
				Thread.sleep(5000);
				Youtube.sendKeys("YtzAFV2jdp8");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[5]/div[1]/div/span/button")).click();
				// Add Experience
				driver.findElement(By.id("experience")).clear();
				driver.findElement(By.id("experience")).sendKeys("5");
				// Add Url
				driver.findElement(By.id("addIngredientCartLink")).sendKeys("http://www.taste.com.au/recipes/classic-american-grilled-burger/PPI6dmmZ?r=recipes/americanrecipes&c=c522b22a-85cf-402a-84ed-13bf7e5353c3/American%20recipes");
				Thread.sleep(4000);
				// Add Recipe Description
				WebElement body = driver.findElement(By.id("description-text_ifr"));
				body.sendKeys("     Golden buttermilk onion rings add extra flavour and crunch to this classic American grilled burger.Spread the base and tops of the rolls with mayonnaise. Top bases with lettuce, tomato, gherkin, meat patties and onion rings. Top with roll tops.");
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				// Add Key Skills
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[9]/div/div/span/input[2]")).sendKeys("a");
				Thread.sleep(2000);
				 driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[9]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[9]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				// Add Serves
//				driver.findElement(By.xpath("//*[@id='yield']")).click();
//				driver.findElement(By.xpath("//*[@id='yield']")).clear();
//				driver.findElement(By.xpath("//*[@id='yield']")).sendKeys("5");
//				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='difficulty']/option[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='cuisine']/option[25]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div[2]/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div[2]/ul/li[1]/a/label/input")).click();
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div[2]/ul/li[4]/a/label/input")).click();
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div[2]/ul/li[7]/a/label/input")).click();
				// Select Category
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div[3]/div/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div[3]/div/ul/li[4]/a/label/input")).click();
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div[3]/div/ul/li[12]/a/label/input")).click();
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[4]/div[3]/div/ul/li[15]/a/label/input")).click();
				
				/*// Select Timing
				driver.findElement(By.id("prep")).clear();
				driver.findElement(By.id("prep")).sendKeys("2");
				Thread.sleep(2000);
				driver.findElement(By.id("cook")).clear();
				driver.findElement(By.id("cook")).sendKeys("5");
				Thread.sleep(2000);
				driver.findElement(By.id("activation")).clear();
				driver.findElement(By.id("activation")).sendKeys("3");
				Thread.sleep(2000);
				driver.findElement(By.id("total")).clear();
				driver.findElement(By.id("total")).sendKeys("10");*/
				
				//Add Asin
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[6]/div/div/div/input")).sendKeys("Fast Food");
				driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[6]/div/div/div/input")).sendKeys(Keys.ENTER);
				
				if (driver.findElement(By.linkText("Save")).isDisplayed()){
					driver.findElement(By.linkText("Save")).click();
				
	}}

}

















