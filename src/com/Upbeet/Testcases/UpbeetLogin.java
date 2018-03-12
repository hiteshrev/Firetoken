/**
 * 
 */
package com.Upbeet.Testcases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Dell-1
 *
 */
public class UpbeetLogin {
	private static WebDriver driver;
	static JavascriptExecutor jse = (JavascriptExecutor)driver;
	@Test
	public void verifyloginupbeet()
	{
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
	    AddSharing login = new AddSharing();
	    login.LoginPage(driver);
	    login.username("testrevin@gmail.com");
	    login.password("123456");
	    login.loginButton();
	    
}
}
