package com.Upbeet.Testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class AddSharing {
	private WebDriver driver;

	By username=By.id("ID");
 	By password=By.id("Password");
 	By loginButton=By.id("loginButton");
	@Test(priority=1)
	
	 public void Login() throws InterruptedException 	  {		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\chromedriver.exe");
    driver = new ChromeDriver(); 
    String appUrl = "http://dev.theupbeetkitchen.com/";
    driver.get(appUrl);
  	Thread.sleep(2000);
	driver.findElement(By.id("close_tour")).click();
  	driver.manage().window().maximize();
      
   //For shift Join to Login Button
  	JavascriptExecutor jse = (JavascriptExecutor)driver;
 	jse.executeScript("$('#signin_div > .shw_div').trigger('click')" );
 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	}
	public void LoginPage(WebDriver driver)
	{
		this.driver=driver;
	 	}
	public void LoginToUpbeet(String userid, String pass)
	{
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();		
	 	}
	public void username(String uid)
	{
		driver.findElement(username).sendKeys(uid);
	}
	public void password(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	public void loginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	}
