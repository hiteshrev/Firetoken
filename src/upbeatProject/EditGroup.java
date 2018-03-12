package upbeatProject;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EditGroup {

	private WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	@Test(priority=1)	
	
		public void Login() throws InterruptedException, AWTException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			String appUrl = "http://dev.theupbeetkitchen.com/";
			driver.get(appUrl);
			Thread.sleep(2000);
			driver.findElement(By.id("close_tour")).click();
			driver.manage().window().maximize();
			// For shift Join to Login Button
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("$('#signin_div > .shw_div').trigger('click')");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("ID")).sendKeys("HappyCustomers@theupbeetkitchen.com");
			driver.findElement(By.id("Password")).sendKeys("GrtFd@5075");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
			
		}
	@Test(priority=2)
	public void Edit() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element =driver.findElement(By.linkText("Connect"));	 
		Actions action = new Actions(driver);	 
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Groups")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("srch")).sendKeys("The Chefs Group");
		driver.findElement(By.id("connect-search-btn")).click();
		driver.findElement(By.xpath("//*[@id='result_block']/div/a/div[2]/img")).click();	
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Cholesterol");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Quick Class");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
        //System.out.println(driver.findElement(By.id("add_events_to_group")));
        if(driver.findElement(By.id("add_events_to_group")).isDisplayed()){
        driver.findElement(By.id("add_events_to_group")).click();
        Thread.sleep(4000);
        }
        driver.findElement(By.linkText("Members")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[2]/div/ul/li[3]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Tomatillo");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Latin");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.id("add_recipes_to_group")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Main-1']/div/div[1]/a[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[6]/div/span/input[2]")).sendKeys("Sumit Jain");
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[6]/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[6]/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[8]/a[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("customLogout")).click();

	}
}
