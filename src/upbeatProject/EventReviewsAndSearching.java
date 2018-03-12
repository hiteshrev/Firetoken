package upbeatProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventReviewsAndSearching {
	private WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	@Test(priority=1)	
		public void Login() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			String appUrl = "http://dev.theupbeetkitchen.com/";
			driver.get(appUrl);
			Thread.sleep(2000);
			driver.findElement(By.id("close_tour")).click();
			driver.manage().window().maximize();
			// For shift Join to Login Button
			/*JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("$('#signin_div > .shw_div').trigger('click')");*/
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("customLogin")).click();
			driver.findElement(By.id("ID")).sendKeys("testingrevin@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(3000);
		    String PageTitle = driver.getTitle();
			System.out.println("Page title: - "+PageTitle);
			Assert.assertTrue(PageTitle.equalsIgnoreCase("My Account"), "Page title doesn't match");
			}
	
	@Test(priority=2)	
	public void SearchEvent()throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Events")).click();
		driver.findElement(By.xpath("//*[@id='location_accordion']/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id='location_accordion']/input[1]")).sendKeys("78652");
		driver.findElement(By.xpath("//*[@id='location_accordion']/input[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page_block_1306']/div/div[2]/div[1]/div[1]/div/form/div/input[1]")).sendKeys("San Diego Bay Wine + Food Fest");
		driver.findElement(By.id("connect-search-btn")).click();
		driver.findElement(By.xpath("//*[@id='page_block_']/div/div[2]/div[1]/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page_block_1373']/div/div[2]/div[3]/div[1]/div/div[2]/div[2]/center/select")).sendKeys("NotGoing");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page_block_1373']/div/div[2]/div[3]/div[1]/div/div[2]/div[2]/center/select")).sendKeys("Maybe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page_block_1373']/div/div[2]/div[3]/div[1]/div/div[2]/div[2]/center/select")).sendKeys("Going");
		Thread.sleep(3000);
        driver.navigate().to("https://dev.theupbeetkitchen.com/m/events");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='location_accordion']/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id='location_accordion']/input[1]")).sendKeys("78652");
		driver.findElement(By.xpath("//*[@id='location_accordion']/input[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='accordions']/div[1]/div[1]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div/div[3]/div/div[1]/div[2]/ul/li[2]/label/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='accordions']/div[2]/div[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div/div[3]/div/div[2]/div[2]/ul/li[2]/label/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div/div[3]/div/div[2]/div[2]/ul/li[5]/label/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='accordions']/div[3]/div[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div/div[3]/div/div[3]/div[2]/ul/li[1]/label/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page_block_']/div/div[2]/div[1]/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Recipe's")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Reviews")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("write_review")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='review_form']/div/span[4]")).click();
		driver.findElement(By.id("review_message")).sendKeys("Hi !! Thanks for adding me");	
		Thread.sleep(3000);
		driver.findElement(By.id("send_review")).click();	
		driver.findElement(By.id("customLogout")).click();
		driver.quit();
	}
	
	
	
}
