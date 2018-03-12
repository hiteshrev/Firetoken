package upbeatProject;
import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class RecipeCloneAndChangeMetrics {
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
	public void MetricChange() throws InterruptedException, AWTException{
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
		Thread.sleep(4000);
		driver.findElement(By.id("tars-widget-fab")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Main-1']/div[5]/ul/li[1]/div/div/span[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Detailed")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Main-1']/div[5]/ul/li[1]/div/div/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='clone_recipe']/img")).click();
		if (driver.findElement(By.linkText("Save")).isDisplayed()){
			driver.findElement(By.linkText("Save")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("customLogout")).click();
			}}
	@Test(priority = 3)
	public void RecipeApproval() throws InterruptedException, AWTException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://dev.theupbeetkitchen.com/administration");
		driver.findElement(By.id("admin_username")).sendKeys("HappyCustomers@theupbeetkitchen.com");
		driver.findElement(By.id("admin_password")).sendKeys("vhKP.xrj");
		driver.findElement(By.id("admin_login_form_submit")).submit();
		if(driver.findElement(By.linkText("continue trial")).isDisplayed()){
			driver.findElement(By.linkText("continue trial")).click();
		}
		driver.navigate().to("https://dev.theupbeetkitchen.com/administration/recipe.php");
		driver.findElement(By.xpath("//*[@id='main_cont']/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[1]/div[2]/select/option[2]")).click();
		driver.findElement(By.name("save")).click();
		Alert alert = driver.switchTo().alert();
	 	alert.accept();
	 	driver.navigate().to("https://dev.theupbeetkitchen.com");
		driver.findElement(By.id("customLogout")).click();
					}	
	@Test(priority = 4)
	public void EditDeleteCloneRecipe() throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("customLogin")).click();
		driver.findElement(By.id("ID")).sendKeys("testingrevin@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("loginButton")).submit();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/header/div[2]/div/div/div/div[2]/div/div/div[2]/ul/li[2]/a"));    
		for(WebElement ele : elements){
		    System.out.println(ele.getText());
	     ele.click();
		}
		driver.findElement(By.xpath("//*[@id='cookProfileInfo']/div[2]/div[5]/div[2]/div/div[1]/ul/li[2]/div/a/div[2]/img")).click();
		driver.findElement(By.xpath("//*[@id='Main-1']/div[1]/a[9]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("deleteThis")).click();
		
		if(driver.findElement(By.id("deleteThis")).isDisplayed())
		{
			driver.findElement(By.id("deleteThis")).click();
		}
		
		driver.findElement(By.id("customLogout")).click();
	}
}

