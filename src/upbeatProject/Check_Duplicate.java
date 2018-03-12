package upbeatProject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;
@Test
public class Check_Duplicate {
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
		driver.findElement(By.id("Password")).sendKeys("ubkGrtFd@5075");
		driver.findElement(By.id("loginButton")).submit();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Recipes")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id='Eats_Anything_selectedfilter']/span")).click();
		Thread.sleep(3000L);
		//driver.findElement(By.id("ubk_tested")).click();
		//Thread.sleep(4000);
		WebElement slider = driver.findElement(By.id("sliders_range"));
		int width = slider.getSize().getWidth();
		Actions move = new Actions(driver);
		org.openqa.selenium.interactions.Action action = move.dragAndDropBy(slider, ((width * 100) / 100), 0).build();
		action.perform();
		Thread.sleep(7000L);
		new Actions(driver);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		((JavascriptExecutor) driver).executeScript("scroll(0,20000)");
		Thread.sleep(3000L);
		WebElement box = driver.findElement(By.xpath("//*[@id='page_block_1261']/div/div[2]/div[4]"));
		List<WebElement> names = box.findElements(By.tagName("a"));
		int i;
		int k;
		k = 0;
		List<String> names1 = new ArrayList<String>();
		List<String> names2 = new ArrayList<String>();
		for (i = 0; i < names.size(); i++) {
			String value_i = names.get(i).getText().trim();
			if (!value_i.trim().equals("")) {
				k++;
				if (!value_i.equalsIgnoreCase("")) {
					names1.add(value_i);
					names2.add(value_i);
				}
				System.out.println(value_i + "--" + k);
			}
		}
		Set<String> unique = new HashSet<>();
		List<String> duplicates = new ArrayList<>();
		for (String n : names1) {
			if (!unique.add(n)) {
				duplicates.add(n);
			}
		}
		System.out.println(" Duplicate Recipes Name : " + duplicates.toString());
		System.out.println(" Total number of Duplicate Recipes:" + duplicates.size());
		driver.close();
	}
}
