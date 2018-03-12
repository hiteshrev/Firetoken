package upbeatProject;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
class EditProfileEndUser {

	private static WebDriver driver;
	static JavascriptExecutor jse = (JavascriptExecutor)driver;
	@Test(priority=1)
  public void Login() throws InterruptedException 
  {	
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\chromedriver.exe");
	    driver = new ChromeDriver();		 	
	    String appUrl = "https://dev.theupbeetkitchen.com/";
	    driver.get(appUrl);
	  	Thread.sleep(2000);
	  	driver.findElement(By.id("close_tour")).click();
	  	driver.manage().window().maximize();
          
	   //For shift Join to Login Button
	  	JavascriptExecutor jse = (JavascriptExecutor)driver;
	 	jse.executeScript("$('#signin_div > .shw_div').trigger('click')" );
	  	
	 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		driver.findElement(By.id("ID")).sendKeys("testrevin@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("loginButton")).submit();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		String PageTitle = driver.getTitle();
		System.out.println("Business User: - "+PageTitle);
	
  }
	@Test(priority=2)
		public void EditProfilePage()throws InterruptedException {
		
		 driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/header/div[2]/div/div/div/div[2]/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cookProfileInfo']/div[2]/div[3]/div[1]/div[2]/a")).click();
		String FirstName  = driver.findElement(By.name("FirstName[0]")).getText();
		 if(FirstName != "") {
			 driver.findElement(By.xpath("//*[@id='edit_form_table']/tbody/tr[26]/td[2]/div[2]/div/input")).click();
		 }
		 else {
			 
		 
	driver.findElement(By.name("FirstName[0]")).clear();
		driver.findElement(By.name("FirstName[0]")).sendKeys("William");
		driver.findElement(By.name("LastName[0]")).clear();
		driver.findElement(By.name("LastName[0]")).sendKeys("Cowper");
		driver.findElement(By.name("Sex[0]")).click();
		driver.findElement(By.name("Sex[0]")).sendKeys("Man");
		Thread.sleep(2000);
		driver.findElement(By.name("DateOfBirth[0]")).click();	 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
		//Date of Birth
		WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  		     
		for (WebElement cell: columns)
			{  
				if (cell.getText().equals("25"))
					{  
						cell.findElement(By.linkText("25")).click();  
						break;  
					}
			}		
		driver.findElement(By.name("Password[0]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("DescriptionMe[0]")).clear();
		driver.findElement(By.name("DescriptionMe[0]")).sendKeys("Self-motivated professional with outstanding skills as both Chef and Manager.Superior leadership and interpersonal skills; ability to build rapport with customers and colleagues; innate ability to interact effectively with people of various cultures and backgrounds and succeed in high-pressure challenging and deadline-driven environments. Seeking to bring strong supervisory food prep and organizational skills to the table with a respected organization that values hard work commitment and vision.");
		Thread.sleep(2000);
		driver.findElement(By.name("Address[0]")).clear();
		driver.findElement(By.name("Address[0]")).sendKeys("4916 W Gary Way, Laveen, AZ, 85339");
		Thread.sleep(2000);
		driver.findElement(By.name("Country[0]")).sendKeys("India");
		Thread.sleep(2000);
		driver.findElement(By.name("State[0]")).sendKeys("DE");
		Thread.sleep(2000);
		driver.findElement(By.name("Preferdiet[0][]")).sendKeys("Vegan");
		Thread.sleep(2000);
		driver.findElement(By.name("Phone[0]")).clear();
		driver.findElement(By.name("Phone[0]")).sendKeys("98789778888888");
		Thread.sleep(2000);
		driver.findElement(By.name("Website[0]")).clear();
		driver.findElement(By.name("Website[0]")).sendKeys("http://dev.theupbeetkitchen.com");
		Thread.sleep(2000);
		driver.findElement(By.name("paypal_email[0]")).clear();
		driver.findElement(By.name("paypal_email[0]")).sendKeys("aman-buyer@revinfotech.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='edit_form_table']/tbody/tr[24]/td[2]/div[2]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("BusinessName[0]")).clear();
		driver.findElement(By.name("BusinessName[0]")).sendKeys("Chef Master");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='edit_form_table']/tbody/tr[21]/td[2]/div[2]/select/option[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='edit-profile-form_input_Profession_0____CSA']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='edit-profile-form_input_Profession_0____Dietician']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='edit-profile-form_input_Profession_0____Personal_Trainer']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='edit-profile-form_input_Profession_0____Private_Chef']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='edit_form_table']/tbody/tr[26]/td[2]/div[2]/div/input")).click();
		 }
	    	}
		//photo Uploading & Video Upload.........
		@Test(priority=3)
		public void photoupload ()throws InterruptedException, AWTException {
			driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		WebElement uploading=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/form/span/span"));
	    uploading.click();
	    StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Pictures\\Weekly-Meal-Plan.jpg");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div/div/div[2]/form/div/div/div[1]/div[2]/div/div/div/div/select/option[2]")).click();
	    Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		Thread.sleep(2000);
	    WebElement Youtube=driver.findElement(By.id("video_id"));
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Youtube.clear();
		Youtube.sendKeys("CgjfzLMmGV0");
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='page_block_1338']/div/div[2]/form/div/div/div[1]/div[2]/div/div/div/div/div/span/button")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='page_block_1338']/div/div[2]/form/div/input")).click();
	    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		}
	    @Test(priority=4)	    
	    public void Credentials_Verification ()throws InterruptedException, AWTException{
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div/div/div[2]/div[2]/form/div[1]/div[1]/div/table/tbody/tr[1]/td[2]/div/div/input[1]")).clear();
	    driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/div[2]/div/div/div[2]/div[2]/form/div[1]/div[1]/div/table/tbody/tr[1]/td[2]/div/div/input[1]")).sendKeys("St. Joseph Chef School");
	    
	    //Date Selector
	    Thread.sleep(2000);
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
	   jse.executeScript("$('input[name=\"eduTo[]\"]').val('Mar 2013');");
	   Thread.sleep(2000);
	   JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	   jse1.executeScript("$('input[name=\"eduFrom[]\"]').val('Mar 2015');");
	   Thread.sleep(2000);
	   driver.findElement(By.name("workCompany[]")).clear();
		driver.findElement(By.name("workCompany[]")).sendKeys("Chef's Group");
		Thread.sleep(2000);
		driver.findElement(By.name("jobtitle[]")).clear();
		driver.findElement(By.name("jobtitle[]")).sendKeys("Cook");
		Thread.sleep(2000);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("$('input[name=\"workTo[]\"]').val('Mar 2016');");
		Thread.sleep(2000);
		JavascriptExecutor jse3 = (JavascriptExecutor)driver;
		jse3.executeScript("$('input[name=\"workFrom[]\"]').val('Mar 2017');");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='tokenfield-tokenfield']")).clear();
	    driver.findElement(By.xpath("//*[@id='tokenfield-tokenfield']")).sendKeys("blue");
	    Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='tokenfield-tokenfield']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//*[@id='tokenfield-tokenfield']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='blogInput']")).clear();
        driver.findElement(By.xpath("//*[@id='blogInput']")).sendKeys("http://gillettenutrition.com/gillette-nutrition-blog/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='bloggerInput']")).clear();
        driver.findElement(By.xpath("//*[@id='bloggerInput']")).sendKeys("http://www.upbeet.ca/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='facebook']")).clear();
        driver.findElement(By.xpath("//*[@id='facebook']")).sendKeys("https://www.facebook.com/upbeet/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='instagram']")).clear();
        driver.findElement(By.xpath("//*[@id='instagram']")).sendKeys("https://www.instagram.com/feelingupbeat/?hl=en");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='twitter']")).clear();
        driver.findElement(By.xpath("//*[@id='twitter']")).sendKeys("https://twitter.com/upbeetfoods?lang=en");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='pintrest']")).clear();
        driver.findElement(By.xpath("//*[@id='pintrest']")).sendKeys("https://www.pinterest.com/pin/409475791091555183/");
        Thread.sleep(2000);
        WebElement UploadImg = driver.findElement(By.xpath("//*[@id='verifyCert']/div[2]/a"));
        UploadImg.click();
        StringSelection ss = new StringSelection("C:\\Users\\Dell-1\\Pictures\\Weekly-Meal-Plan.jpg");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='uploadCertLicn']/div/input[3]")).clear();
        driver.findElement(By.xpath("//*[@id='uploadCertLicn']/div/input[3]")).sendKeys("Chief");
        Thread.sleep(2000);
 	   JavascriptExecutor jse4 = (JavascriptExecutor)driver;
 	   jse4.executeScript("$('input[name=\"certTo[]\"]').val('Mar 2014');");
 	   Thread.sleep(2000);
 	  JavascriptExecutor jse5 = (JavascriptExecutor)driver;
	   jse5.executeScript("$('input[name=\"certFrom[]\"]').val('Mar 2016');");
	   Thread.sleep(2000);
	     if(driver.findElement(By.id("save_verify_credentials")).isDisplayed()){     
	        driver.findElement(By.id("save_verify_credentials")).click();   
	        System.out.println("clicked"); 
	    } else  { 
	        driver.findElement(By.id("save_credentials")).click(); 
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id='page_block_1336']/div/div[2]/div/a")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.id("customLogout")).click();
	        System.out.println("User logged out after add Details successfully");
	        	    }
	     
	    }
	   	    @Test(priority=5)	    
	    public void VerifyByAdmin () throws InterruptedException {
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	driver.navigate().to("http://dev.theupbeetkitchen.com/administration");
	        Thread.sleep(2000);
	        driver.findElement(By.id("admin_username")).sendKeys("admin");
	        Thread.sleep(2000);
	        driver.findElement(By.id("admin_password")).sendKeys("UpBeet@5075");
	        Thread.sleep(2000);   
	        driver.findElement(By.id("admin_login_form_submit")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[3]/div/div/table/tbody/tr/td[1]/div/div[20]/div/a")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id='main_cont']/div[2]/div/div[2]/div/form/input[1]")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.name("apply")).click(); 
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[4]/a/div/i")).click();         
	    }
	    @Test(priority=6)	    
	    public void LoginAsVerifiedBusinessUser () throws InterruptedException {
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	driver.navigate().to("http://dev.theupbeetkitchen.com/");
	        Thread.sleep(2000);
	        driver.findElement(By.id("customLogin")).click();	        
		   //For shift Join to Login Button		  	
		 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			driver.findElement(By.id("ID")).sendKeys("testrevin@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("loginButton")).submit();
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[3]/header/div[2]/div/div/div/div[2]/div/div[2]/ul/li[2]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("customLogout")).click();
	    }
	
}