package com.Upbeet.Testcases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LoginUpbeetNew {
	private static WebDriver driver;
	static JavascriptExecutor jse = (JavascriptExecutor)driver;
	public void verifyloginupbeet(){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\chromedriver.exe");
    driver = new ChromeDriver(); 
    String appUrl = "http://dev.theupbeetkitchen.com/";
    driver.get(appUrl);
    driver.findElement(By.id("close_tour")).click();
  	driver.manage().window().maximize();
       //For shift Join to Login Button
  	JavascriptExecutor jse = (JavascriptExecutor)driver;
 	jse.executeScript("$('#signin_div > .shw_div').trigger('click')" );
 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
    
}
	public class LoginPage{
		
		
		@FindBy(id="ID")
		WebElement username;
		@FindBy(how=How.ID,using="Password")
		WebElement password;
		@FindBy(how=How.XPATH,using="//*[@id='loginButton']")
		WebElement submit_button;
		@FindBy(how=How.LINK_TEXT,using="Click Here")
		WebElement ForgetPasswordLink;
		
		public void login_upbeet (String userid, String pass){
			
			username.sendKeys(userid);
			password.sendKeys(pass);
			submit_button.click();
		
		
	}
	
}
}