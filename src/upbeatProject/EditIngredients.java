package upbeatProject;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class EditIngredients {
	private static WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	@Test(priority = 1)
public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(d);
		String appUrl = "https://dev.theupbeetkitchen.com";
		driver.get(appUrl);
		Thread.sleep(2000);
		driver.findElement(By.id("close_tour")).click();
		driver.manage().window().maximize();
		// For shift Join to Login Button
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("$('#signin_div > .shw_div').trigger('click')");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("ID")).sendKeys("HappyCustomers@theupbeetkitchen.com");
		driver.findElement(By.id("Password")).sendKeys("suq+pbNb");
		driver.findElement(By.id("loginButton")).submit();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//Click on Course  Tab
		WebElement element = driver.findElement(By.linkText("Learn"));       
		Actions action = new Actions(driver); 
		action.moveToElement(element).build().perform(); 
		driver.findElement(By.linkText("Ingredients")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Thread.sleep(4000);
		   for(int i=0;i<=198;i++){
			System.out.println(i);
			String return_value = (String)jse.executeScript("return $('.result-block div').eq(1).find('a').attr('id');");
			jse.executeScript("var id = $('.result-block div').eq(1).find('a').attr('id'); $('#'+id).append(id)");
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
			driver.findElement(By.id(return_value)).sendKeys(selectLinkOpeninNewTab);
			Thread.sleep(4000);
			 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
		    if (driver.findElement(By.xpath("//*[@id='buttonbox-1']/a[2]")).isDisplayed()){
			driver.findElement(By.xpath("//*[@id='buttonbox-1']/a[2]")).click();
			}
			driver.findElement(By.linkText("Save")).click();
			driver.close();
			Thread.sleep(4000);
			driver.switchTo().window(tabs.get(0));
				}}
				}
