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
import org.testng.Assert;
import org.testng.annotations.Test;
public class AddEventDetails {
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
			driver.findElement(By.id("ID")).sendKeys("datatesting266@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(3000);
		    String PageTitle = driver.getTitle();
			System.out.println("Page title: - "+PageTitle);
			Assert.assertTrue(PageTitle.equalsIgnoreCase("My Account"), "Page title doesn't match");
			}
		@Test(priority=2)
	public void AddEvent() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Events")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div/div/div[2]/div[3]/div/div[1]/a/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Recipe's")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Mexican Corn and Zucchini Fritter");
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Thai Shrimp and Spinach");
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("$('#add_recipes_to_group').click();");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Media")).click();
		WebElement element1= driver.findElement(By.xpath("//*[@id='media_from']/a"));
		element1.click();
		Thread.sleep(4000);
		    StringSelection ss1 = new StringSelection("C:\\Users\\Dell-1\\Downloads\\Dr-Legumes.jpg");
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
	    Thread.sleep(2000);
	    driver.findElement(By.id("save_media")).click();
	    driver.findElement(By.id("customLogout")).click();
		
				}
}
