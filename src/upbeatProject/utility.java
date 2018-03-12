package upbeatProject;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class utility{
	 
		public static void captureScreenshot(WebDriver driver, String screenshotname) 
		{
			try
			{
				TakesScreenshot screenshot =(TakesScreenshot)driver;
				
				File source = screenshot.getScreenshotAs(OutputType.FILE);
				
				FileUtils.copyFile(source, new File("./Screenshots/"+screenshotname+".png"));
				
				System.out.println("Screenshot Taken");
				
			}catch(Exception excep)
			{
				System.out.println("Throwing exception while taking screenshot" +excep.getMessage());
			}
	 
		}
	 
	}