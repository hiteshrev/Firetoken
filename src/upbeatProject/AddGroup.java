package upbeatProject;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
//import java.io.File;
import java.util.concurrent.TimeUnit;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AddGroup {
	
	private WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	@Test(priority=1)	

		public void Login() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			String appUrl = "https://live.theupbeetkitchen.com/";
			driver.get(appUrl);
			Thread.sleep(2000);
			driver.findElement(By.id("close_tour")).click();
			driver.manage().window().maximize();
			// For shift Join to Login Button
			/*JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("$('#signin_div > .shw_div').trigger('click')");*/
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("customLogin")).click();
			driver.findElement(By.id("ID")).sendKeys("HappyCustomers@theupbeetkitchen.com");
			driver.findElement(By.id("Password")).sendKeys("GrtFd@5075");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
				}
	@Test(priority=2)
		 public void AddNewGroup() throws InterruptedException, AWTException{
		WebElement element = driver.findElement(By.linkText("Connect"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Groups")).click();
		driver.findElement(By.linkText("Add New")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/ul/li[1]/div/div/span[3]")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("title")).sendKeys("The Chefs Group");
	WebElement uploading=driver.findElement(By.xpath("//*[@id='editCourseMainPhoto']/a/img"));
    uploading.click();		    	   
    driver.findElement(By.xpath("//*[@id='editCourseMainPhoto']/a/img"));
	StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Downloads\\Dr-Legumes.jpg");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000);
    driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
	Thread.sleep(2000);
	//Add youtube video...
	driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div/select/option[2]")).click();
	Thread.sleep(2000);
	WebElement Youtube=driver.findElement(By.id("video_id"));
	driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
	Thread.sleep(2000);
	Youtube.sendKeys("CgjfzLMmGV0");
	driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[5]/div/div/span/button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[6]/div/span/input[2]")).sendKeys("Jaspreet singh");
	Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[6]/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[6]/div/span/input[2]")).sendKeys(Keys.ENTER);
	 Thread.sleep(2000);
     WebElement body = driver.findElement(By.id("description-text_ifr"));
     body.sendKeys("Lots of companies over promise and under deliver. At The Subdus Group, we are the complete opposite, we over deliver week after week,  providing you with great products and our personalized involvement are more than just words… it’s what we do. We only source the best products from farmers and exporters who share our passion for Truffles. That way, you know you’re receiving the highest quality possible. “Good enough” is just not an option for us. Truffles are the diamonds of the kitchen and we care about every truffle, every chef and every client who enjoys them.");
     driver.switchTo().defaultContent();
     Thread.sleep(3000);
     driver.findElement(By.linkText("Save")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		//driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[2]/div/ul/li[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Table Talk & Taste");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Health");
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
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Quinoa Bean");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Artichoke");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("add_recipes_to_group")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[2]/div/ul/li[5]/a")).click();
		Thread.sleep(2000);
		WebElement element1= driver.findElement(By.xpath("//*[@id='media_from']/a"));
		element1.click();
		Thread.sleep(4000);
		    StringSelection ss1 = new StringSelection("C:\\Users\\Dell-1\\Downloads\\870636.jpg");
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
	    Thread.sleep(4000);
	  	
	/*@Test(priority=3)
	public void EditGroup() throws InterruptedException{
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
		driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[2]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Cholesterol");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Quick Class");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b2']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("add_events_to_group")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[2]/div/ul/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[2]/div/ul/li[4]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Tomatillo Salsa Tacos with Baked Plantains");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys("Latin American Casserole");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='b4']/div/div[1]/div/div[1]/div/div/span/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
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
	@Test(priority=4)
	 public void LoginTeamMember() throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.id("customLogin")).click();
	driver.findElement(By.id("ID")).sendKeys("jaspreet@revinfotech.com");
	driver.findElement(By.id("Password")).sendKeys("123456");
	driver.findElement(By.id("loginButton")).submit();
	Thread.sleep(2000);
	WebElement element =driver.findElement(By.linkText("Connect"));	 
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	driver.findElement(By.linkText("Groups")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='result_block']/div/a/div[2]/img")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[2]/div/ul/li[2]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Members")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Recipe's")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("write_review")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='review_form']/div/span[4]")).click();
	driver.findElement(By.id("review_message")).sendKeys("Hi !! Thanks for adding me");	
	Thread.sleep(2000);
	driver.findElement(By.id("send_review")).click();	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='join_grp']/img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='leave_grp']/img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='join_grp']/img")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("customLogout")).click();

	}
	@Test(priority=5)
	 public void DeleteGroup() throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.id("customLogin")).click();
	driver.findElement(By.id("ID")).sendKeys("HappyCustomers@theupbeetkitchen.com");
	driver.findElement(By.id("Password")).sendKeys("UpBeet@5075");
	driver.findElement(By.id("loginButton")).submit();
	Thread.sleep(2000);
	WebElement element =driver.findElement(By.linkText("Connect"));	 
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	driver.findElement(By.linkText("Groups")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='result_block']/div[2]/a/div[2]/img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[3]/div/img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='Container']/div[2]/div[2]/div/ul/li[5]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='del_grp_btn']/img")).click();
	 Alert alert = driver.switchTo().alert();
	 	alert.accept();
	 	WebElement element1 =driver.findElement(By.linkText("Connect"));	 
		Actions action1 = new Actions(driver);
		action1.moveToElement(element1).build().perform();
		driver.findElement(By.linkText("Groups")).click();*/
		driver.findElement(By.id("customLogout")).click();
	
		driver.close();
	}	
/*	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				Thread.sleep(3000);
				FileUtils.copyFile(src, new File("C:\\Users\\Dell-1\\workspace\\upbeatProject\\Screenshots"+result.getName()+".png"));
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}} */
		}
