package upbeatProject;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class AddRecipeToShoplistSelectSubsitute {
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
		driver.findElement(By.id("ID")).sendKeys("jaspreet@revinfotech.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("loginButton")).submit();
		Thread.sleep(2000);
			}	
	@Test (priority=2)
	public void AddtoShoppinglist() throws InterruptedException, AWTException{
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
		driver.findElement(By.xpath("//*[@id='page_block_1261']/div/div[2]/div[4]/div/div[1]/a[2]/i")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("tars-widget-fab")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Main-1']/div[1]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/input")).sendKeys("10");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button[2]")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[7]/a")).click();
		driver.findElement(By.xpath("//*[@id='1048']/i[2]")).click();
		Thread.sleep(3000);		
		for(int i=1; i<=6; i++)
		{
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div["+i+"]/i[1]")).click();
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div["+i+"]/input")).clear();
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div["+i+"]/input")).sendKeys("7");
			Thread.sleep(i*2000);
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div["+i+"]/i[2]")).click();
			Thread.sleep(i*2000);
			}
		driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div[2]/a")).click();
		driver.findElement(By.id("deleteThis")).click();
	}
}
