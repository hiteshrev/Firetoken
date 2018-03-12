package upbeatProject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
public class EditSkills {
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell-1\\workspace\\UpbeetKitchen\\lib\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(d);
		String appUrl = "http://dev.theupbeetkitchen.com";
		driver.get(appUrl);
		Thread.sleep(2000);
		driver.findElement(By.id("close_tour")).click();
		driver.manage().window().maximize();
	//	driver.findElement(By.id("customLogin")).click();
		// For shift Join to Login Button
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("$('#signin_div > .shw_div').trigger('click')");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("ID")).sendKeys("HappyCustomers@theupbeetkitchen.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("loginButton")).submit();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//Click on Course  Tab
		WebElement element = driver.findElement(By.linkText("Learn"));       
		Actions action = new Actions(driver); 
		action.moveToElement(element).build().perform(); 
		driver.findElement(By.linkText("Skill")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		int l=1;
		int size=0;
		
		for(int i=1;i<=50;i++){
			int k=0;
			WebElement box = driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[4]"));
			List<WebElement> names = box.findElements(By.tagName("a"));
			size=names.size();
			System.out.println("Value of i = " + i);
			if(i>=10 && size%9==0){
				for(int n=1;n<l;n++){
					new Actions(driver);
					Thread.sleep(3000L);
					
					for(int j=20000;j<=n*20000;j++){
						j+=20000;
						k+=20000;
						((JavascriptExecutor) driver).executeScript("scroll("+k+","+j+")");
						Thread.sleep(3000L);
						
					}
				}
			}
			if(i%9==0){
				l++;
			}
			if(i>=173){
			driver.findElement(By.xpath("//*[@id='ip-container']/div[1]/div/div[3]/div[2]/div[4]/div["+i+"]/a/div[2]/img")).click();
			driver.findElement(By.xpath("//*[@id='buttonbox-1']/a[2]")).click();
			driver.findElement(By.linkText("Save")).click();
			Alert alert = driver.switchTo().alert();
		 	alert.accept();
			}
		 	WebElement element1 = driver.findElement(By.linkText("Learn"));       
			Actions action1 = new Actions(driver); 
			action1.moveToElement(element1).build().perform(); 
			driver.findElement(By.linkText("Skill")).click();
            System.out.println("Value" + i);
		}
				}
}