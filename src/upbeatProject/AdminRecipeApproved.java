package upbeatProject;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AdminRecipeApproved {

		private static WebDriver driver;
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	@Test(priority = 1)
	public void RecipeApprovedAdminLogin () throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		String appUrl = "https://dev.theupbeetkitchen.com/";
		driver.get(appUrl);
		/*Thread.sleep(2000);
		driver.findElement(By.id("tars-widget-fab")).click();*/
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
	}
	@Test(priority = 2)
		public void RecipeApproval() throws InterruptedException, AWTException
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.navigate().to("https://dev.theupbeetkitchen.com/administration/recipe.php");
			driver.findElement(By.xpath("//*[@id='main_cont']/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[1]/div[2]/select/option[2]")).click();
			driver.findElement(By.name("save")).click();
			Alert alert = driver.switchTo().alert();
		 	alert.accept();
						}	
		@Test(priority = 3)
		public void SearchingandFilteration () throws InterruptedException, AWTException
		{
		driver.navigate().to("https://dev.theupbeetkitchen.com/m/recipes");
		if (driver.findElement(By.xpath("//*[@id='Eats_Anything_selectedfilter']/span")).isDisplayed()){
			driver.findElement(By.xpath("//*[@id='Eats_Anything_selectedfilter']/span")).click();
		}
		WebElement slider = driver.findElement(By.id("sliders_range"));
		int width = slider.getSize().getWidth();
		Actions move = new Actions(driver);
		org.openqa.selenium.interactions.Action action = move.dragAndDropBy(slider, ((width * 100) / 100), 0).build();
		action.perform();
		Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id='accordion']/div[3]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='Diets']/ul/li[1]")).click();
		driver.findElement(By.xpath("//*[@id='Diets']/ul/li[4]")).click();
		driver.findElement(By.xpath("//*[@id='Diets']/ul/li[7]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='accordion']/div[4]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='Difficulty']/ul/li[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='accordion']/div[6]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='RecipeCategory']/ul/li[4]")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//*[@id='page_block_1261']/div/div[2]/div[4]/div/a/div[2]/img")).isDisplayed()){
		driver.findElement(By.xpath("//*[@id='page_block_1261']/div/div[2]/div[4]/div/a/div[2]/img")).click();
			
}}}