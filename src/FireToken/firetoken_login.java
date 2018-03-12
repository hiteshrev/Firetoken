package FireToken;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class firetoken_login {
	public WebDriver driver;

	  @Parameters("browser")

	  @BeforeClass

	  // Passing Browser parameter from TestNG xml

	  public void beforeTest(String browser) throws InterruptedException {

	  // If the browser is Firefox, then do this

	  if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver","C:\\Users\\Dell-1\\workspace\\upbeatProject\\lib\\geckodriver.exe");
		  driver = new FirefoxDriver();
	  }else if (browser.equalsIgnoreCase("chrome")) { 
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		  driver = new ChromeDriver();
	  } 
	  driver.get("http://www.firetoken.io/"); 
	  Thread.sleep(2000);
		driver.manage().window().maximize();
			  }
	  
	  
	  

	}

